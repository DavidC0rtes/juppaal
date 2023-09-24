package be.unamur.uppaal.juppaal;

import org.jdom.Element;

public class Query extends UppaalElement {
    private Formula formula;
    private CommentFormula comment;
    public Query(Element child) {
        if (child.getChild("formula") != null) {
            formula = new Formula(child.getChild("formula"));
        }
        if (child.getChild("comment") != null) {
            comment = new CommentFormula(child.getChild("comment"));
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

        if (comment != null)
            result.addContent(comment.generateXMLElement());

        return result;
    }
}
