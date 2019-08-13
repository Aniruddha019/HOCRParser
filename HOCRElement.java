package com.perfios.hocrToPDF;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HOCRElement {
	private HOCRElementCoordinates coordinates;
	private Element HOCRHtml;
	private String id;
	private Element parent;
	private List<HOCRElement> elements;
	private String title;

	Pattern p = Pattern.compile("bbox\\s(-?[0-9]+)\\s(-?[0-9]+)\\s(-?[0-9]+)\\s(-?[0-9]+)");

	public HOCRElement(Element hOCRHtml, Element parent,String nextTag, String nextAttribute, String nextClass) {
		this.coordinates = new HOCRElementCoordinates(0, 0, 0, 0);
		this.HOCRHtml = hOCRHtml;
		this.id = null;
		this.parent = parent;
		this.elements = this.parse(nextTag,nextAttribute,nextClass);
	}

	public List<HOCRElement> parse(String nextTag, String nextAttribute, String nextClass){

		try {
			this.id = this.HOCRHtml.attr("id");
			System.out.println("Id - " + this.id);

			this.title = this.HOCRHtml.attr("title");
			if(this.title!=null) {
				System.out.println("Title - " + this.title);
				Matcher m = p.matcher(this.title);
				if(m.find()) {
					this.coordinates = new HOCRElementCoordinates(Integer.parseInt(m.group(1)),Integer.parseInt(m.group(2)),Integer.parseInt(m.group(3)),Integer.parseInt(m.group(4)));
					System.out.println(this.coordinates);
					System.out.println(this.HOCRHtml.text());
				}
				else {
					if(!(this.HOCRHtml instanceof Document)) {
						throw new IllegalArgumentException("Not valid title property");
					}
				}
			}
			else {
				this.coordinates=new HOCRElementCoordinates(0, 0, 0, 0);
			}
		}
		catch(NullPointerException npointer) {
			this.title=null;
		}

		List<HOCRElement> elements = new ArrayList<HOCRElement>();
		if(nextTag != null && nextClass != null) {
			Elements tagsMatches=this.HOCRHtml.getElementsByTag(nextTag);
			for(Element ele: tagsMatches) {
				if(ele.hasClass(nextAttribute)) {
					if(nextClass.equals("HOCRWord")) {
						elements.add(new HOCRWord(this.HOCRHtml,ele));
					}
					if(nextClass.equals("HOCRLine")) {
						elements.add(new HOCRLine(this.HOCRHtml,ele));
					}
					if(nextClass.equals("HOCRParagraph")) {
						elements.add(new HOCRParagraph(this.HOCRHtml,ele));
					}
					if(nextClass.equals("HOCRArea")) {
						elements.add(new HOCRArea(this.HOCRHtml,ele));
					}if(nextClass.equals("HOCRPage")) {
						elements.add(new HOCRPage(this.HOCRHtml,ele));
					}

				}
			}
		}
		return elements;
	}
	
	public List<HOCRElement> getElementByTagName(String tagName){
        List<HOCRElement> elementTags = new ArrayList<HOCRElement>();
        if(this.parent.toString() != null) {
        	ret
        }
        return elementTags;
    }


}
