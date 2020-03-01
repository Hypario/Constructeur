import java.io.IOException;
import java.util.Scanner;

/**
 * Le rôle de cette classe est de lire un fichier
 * au format markdown et de le traduire dans un
 * autre format à l'aide d'un objet constructeur.
 *
 * @author leberre
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

		boolean ul = false, p = false;

		while (scanner.hasNext()) {
			line = scanner.nextLine();

			// split line into words
			String[] words = line.split(" ", 2);

			// match the first word
			switch (words[0]) {
				case "#":
					constructeur.buildHeader1(words[1]);
					break;
				case "##":
					constructeur.buildHeader2(words[1]);
					break;
				case "###":
					constructeur.buildHeader3(words[1]);
					break;
				case "+":
					if (!ul) {
						constructeur.onBeginUnsortedList();
						ul = true;
					}
					constructeur.buildListItem(words[1]);
					break;
				case "":
					p = ensureEndParagraph(p);
					ul = ensureEndUnsortedList(ul);
					break;
				default:
					ul = ensureEndUnsortedList(ul);
					if (!p) {
						constructeur.onParagraphBegin();
						p = true;
					} else {
						constructeur.buildRawText(System.lineSeparator());
					}
					handleLine(line);
			}
		}
		ensureEndParagraph(p);
		ensureEndUnsortedList(ul);
	}

	/**
	 * assure que la liste est bien terminé
	 * @param ul boolean
	 * @return false
	 */
	private boolean ensureEndUnsortedList(boolean ul) {
		if (ul) {
			constructeur.onEndUnsortedList();
		}
		return false;
	}

	private boolean ensureEndParagraph(boolean p) {
		if (p) {
			constructeur.onParagraphEnd();
		}
		return false;
	}

	private void handleLine(String line) {
		constructeur.buildRawText(line);
	}
}
