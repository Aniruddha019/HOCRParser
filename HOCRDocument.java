package com.perfios.hocrToPDF;

import org.jsoup.nodes.Document;

public class HOCRDocument extends HOCRElement{

	public HOCRDocument(Document hOCRHtml) {
		super(hOCRHtml,null, "div", HOCRPage.HOCRTag, "HOCRPage");
	}
	
}
