/**
 * Permet de construire une représentation HTML.
 *
 * @author leberre
 */
public class HTML implements Constructeur {

    private final StringBuilder string = new StringBuilder();

    public HTML() {
        string.append("<html>");
        newLine();
        string.append("<body>");
        newLine();
    }

    @Override
    public void onParagraphBegin() {
        string.append("<p>");
    }

    @Override
    public void onParagraphEnd() {
        string.append("</p>");
        newLine();
    }

    @Override
    public void buildHeader1(String s) {
        header("h1", s);
    }

    @Override
    public void buildHeader2(String s) {
        header("h2", s);
    }

    @Override
    public void buildHeader3(String s) {
        header("h3", s);
    }

    @Override
    public void onBeginUnsortedList() {
        string.append("<ul>");
        newLine();
    }

    @Override
    public void buildListItem(String s) {
        string.append("<li>").append(s).append("</li>");
        newLine();
    }

    @Override
    public void onEndUnsortedList() {
        string.append("</ul>");
        newLine();
    }

    @Override
    public void buildRawText(String s) {
        string.append(s);
    }

    @Override
    public void buildBold(String s) {
        surround("b", s);
    }

    @Override
    public void buildItalic(String s) {
        surround("i", s);
    }

    @Override
    public String getResult() {
        string.append("</body>");
        newLine();
        string.append("</html>");
        newLine();
        return string.toString();
    }

    private void header(String tag, String s) {
        surround(tag, s);
        newLine();
    }

    private void surround(String tag, String s) {
        string
                .append("<").append(tag).append(">")
                .append(s)
                .append("</").append(tag).append(">");
    }

    private void newLine() {
        string.append(System.lineSeparator());
    }

}
