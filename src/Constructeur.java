
public interface Constructeur {

    void onParagraphBegin();
    
    void onParagraphEnd();
    
    void buildHeader1(String s);
    
    void buildHeader2(String s);
    
    void buildHeader3(String s);
    
    void onBeginUnsortedList();
    
    void buildListItem(String s);
    
    void onEndUnsortedList();
    
    void buildRawText(String s);
    
    void buildBold(String s);
    
    void buildItalic(String s);
    
    String getResult();
}
