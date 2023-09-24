package be.unamur.uppaal.juppaal;

import org.jdom.Element;

import java.util.ArrayList;
import java.util.List;

public class Queries extends UppaalElement{
    private List<Query> queriesList;
    public Queries(Element child) {
        queriesList = new ArrayList<>();
        for (Object query : child.getChildren("query")) {
            if (query instanceof Element) {
                queriesList.add(new Query((Element) query));
            }
        }
    }

    public Queries() {}

    @Override
    public String getXMLElementName() {
        return "queries";
    }

    @Override
    public Element generateXMLElement() {
        Element result = new Element("queries");
        if (queriesList != null) {
            queriesList.forEach(query -> {
                result.addContent(query.generateXMLElement());
            });
        }

        return result;
    }
}
