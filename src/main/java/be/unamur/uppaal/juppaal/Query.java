package be.unamur.uppaal.juppaal;

import org.jdom.Element;

public class Query extends UppaalElement {
    private Formula formula;
    public Query(Element child) {
        if (child.getChild("formula") != null) {
            formula = new Formula(child.getChild("formula"));
        }
    }

    @Override
    public String getXMLElementName() {
        return "query";
    }

    @Override
    public Element generateXMLElement() {
        Element result = new Element("query");
        if (formula != null)
            result.addContent(formula.generateXMLElement());

        return result;
    }
}
