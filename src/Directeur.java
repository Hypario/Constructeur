import java.io.IOException;
import java.util.Scanner;

/**
 * Le rôle de cette classe est de lire un fichier
 * au format markdown et de le traduire dans un
 * autre format à l'aide d'un objet constructeur.
 *
 * @author leberre
 *
 */
public class Directeur {

	private final Constructeur constructeur;

	/**
	 * Initialise un objet Directeur avec un constructeur.
	 *
	 * @param constructeur un traducteur.
	 */
	public Directeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	/**
	 * Lit un fichier markdown et appelle un
	 * objet constructeur sur chaque structure
	 * repérée.
	 *
	 * @param scanner un objet permettant d'accéder au fichier ligne à ligne.
	 * @throws IOException si un problème
	 */
	public void build(Scanner scanner) throws IOException {
		String line;
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			// TODO : analyser le format markdown
		}
	}

}
