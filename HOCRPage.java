package com.perfios.hocrToPDF;

import org.jsoup.nodes.Element;

public class HOCRPage extends HOCRElement{
	public static final String HOCRTag="ocr_page";
	public HOCRPage(Element parent,Element hOCRHtml) {
		super(hOCRHtml, parent,"div",HOCRArea.HOCRTag,"HOCRArea");
	}
	
	
}
