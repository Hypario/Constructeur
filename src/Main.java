import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Permet de lancer la conversion en ligne de commande :
 * 
 * <pre>
 * java Main fichier.md
 * </pre>
 * 
 * pour traduire en HTML.
 * 
 * <pre>
 * java Main HTML|RTF fichier.md
 * </pre>
 * 
 * pour préciser le convertisseur à utiliser.
 * 
 * @author leberre
 *
 */
public class Main {
	public static void main(String[] args) {
		String filename;
		Constructeur builder;
		if (args.length == 0) {
			System.err.println("Usage: java Main [HTML|RTF] fichier.md");
			return;
		}
		if (args.length == 2) {
			filename = args[1];
			try {
				builder = (Constructeur) Class.forName(args[0]).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				builder = new HTML();
			}
		} else {
			filename = args[0];
			builder = new HTML();
		}
		Directeur director = new Directeur(builder);
		
		try (Scanner scanner = new Scanner(new File(filename))) {
			director.build(scanner);
			System.out.println(builder.getResult());
		} catch (FileNotFoundException e) {
			System.err.println("Fichier invalide");
		} catch (IOException e1) {
			System.err.println("Erreur : " + e1.getMessage());
		}

	}
}
