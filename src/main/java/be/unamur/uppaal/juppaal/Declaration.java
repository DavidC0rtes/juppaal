package be.unamur.uppaal.juppaal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Element result = super.generateXMLElement();
		if (!this.toString().isEmpty()) {
			result.addContent(toString());
		}
		return result;
	}

	public List<String> getStrings() {
		return declarations;
	}

	public List<String> getClockDeclarations() {
		List<String> clockNames = new ArrayList<>();
		Pattern clockPattern = Pattern.compile("clock\\s+([a-zA-Z_]([a-zA-Z0-9_])*)(\\s*,\\s*(?:[a-zA-Z_][a-zA-Z0-9_]*))*;");
		for (String declaration: declarations) {
			Matcher matcher = clockPattern.matcher(declaration);
			if (matcher.find()) {
				clockNames.add(matcher.group(1).trim());
				if (matcher.group(3) != null && !matcher.group(3).isBlank()) {
					String[] clocks = matcher.group(3).split(",");
					for (String clock: clocks) {
						if (!clock.isBlank()) clockNames.add(clock);
					}
				}
			}
		}
		return clockNames;
	}

	public void add(String s) {
		declarations.add(s);
	}
	public void remove(String s) {
		declarations.remove(s);
	}
}
