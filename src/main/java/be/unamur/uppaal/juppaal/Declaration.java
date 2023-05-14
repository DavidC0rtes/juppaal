package be.unamur.uppaal.juppaal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.jdom.Element;


public class Declaration extends UppaalElement{
	List<String> declarations = new LinkedList<String>();;
	public Declaration(Element declarationsElement){
		String[] decls = declarationsElement.getText().split("\n");
		declarations.addAll(Arrays.asList(decls));
	}
	
	public Declaration(Declaration declarations) {
		this.declarations.add(declarations.toString().trim());
	}
	
	public void add(Declaration declarations){
		this.declarations.add(declarations.toString().trim());
	}

	public Declaration(String declarations){
		this.declarations = new LinkedList<String>();
		this.declarations.add(declarations.toString().trim());
	}

	public Declaration() {
	}

	@Override
	public String getXMLElementName() {
		return "declaration";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String declaration : declarations){
			sb.append(declaration+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public Element generateXMLElement() {
		if (!this.toString().isEmpty()) {
			Element result = super.generateXMLElement();
			result.addContent(toString());
			return result;
		}

		return null;
	}

	public List<String> getStrings() {
		return declarations;
	}

	public void add(String s) {
		declarations.add(s);
	}
	public void remove(String s) {
		declarations.remove(s);
	}
}
