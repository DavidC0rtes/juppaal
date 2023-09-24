package be.unamur.uppaal.juppaal;

import org.jdom.Element;

public class CommentFormula extends UppaalElement {
    private String content;
    public CommentFormula(Element comment) {
        content = comment.getText();
    }

    public CommentFormula() {}

    @Override
    public String getXMLElementName() {
        return "comment";
    }

    @Override
    public Element generateXMLElement() {
        Element result = super.generateXMLElement();
        result.addContent(this.content);
        return result;
    }
}
