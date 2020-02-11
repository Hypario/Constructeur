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

        boolean p = false, ul = false;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.startsWith("# ")) {
                constructeur.buildHeader1(line.substring(2));
            } else if (line.startsWith("## ")) {
                constructeur.buildHeader2(line.substring(3));
            } else if (line.startsWith("### ")) {
                constructeur.buildHeader2(line.substring(4));
            } else if (!line.equals("")) {
                if (!p) {
                    constructeur.onParagraphEnd();
                    p = false;
                } else {
                    constructeur.onParagraphBegin();
                    constructeur.buildRawText(line);
                    p = true;
                }
            }
        }
    }
}
