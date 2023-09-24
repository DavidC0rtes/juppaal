package be.unamur.uppaal.juppaal;

import org.jdom.Element;

public class Formula extends UppaalElement {
    private String content;
    public Formula(Element child) {
        content = child.getText();
    }

    public Formula(){}
    @Override
    public String getXMLElementName() {
        return "formula";
    }

    @Override
    public Element generateXMLElement() {
        Element result = super.generateXMLElement();
        result.addContent(this.content);
        return result;
    }
}
