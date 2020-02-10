
/**
 * Permet de construire une représentation RTF.
 *
 * @author leberre
 *
 */
public class RTF implements Constructeur {

	StringBuilder string = new StringBuilder();

	@Override
	public void onParagraphBegin() {
		string.append("{\\pard ");
	}

	@Override
	public void onParagraphEnd() {
		string.append(" \\par}");
	}

	@Override
	public void buildHeader1(String s) {
		header("fs40", s);
	}

	@Override
	public void buildHeader2(String s) {
		header("fs30", s);
	}

	@Override
	public void buildHeader3(String s) {
		header("fs20", s);
	}

	@Override
	public void onBeginUnsortedList() {
		string.append("\\line{\\pard\\li500\\ql");
		newLine();
	}

	@Override
	public void buildListItem(String s) {
		string.append("{\\b * } ").append(s).append("\\line");
	}

	@Override
	public void onEndUnsortedList() {
		string.append("\\line\\par}");
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
		return string.toString();
	}

	private void header(String tag, String s) {
		string
				.append("{\\pard\\qc\\b\\").append(tag)
				.append(s)
				.append(" \\par}");
		newLine();
	}

	private void surround(String tag, String s) {
		string.append("{\\").append(tag).append(" ").append(s).append(" }");
	}

	private void newLine() {
		string.append(System.lineSeparator());
	}

}
