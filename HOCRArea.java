package com.perfios.hocrToPDF;

import org.jsoup.nodes.Element;

public class HOCRArea extends HOCRElement{
	public static final String HOCRTag="ocr_carea";
	public HOCRArea(Element parent,Element hOCRHtml) {
		super(hOCRHtml, parent,"p",HOCRParagraph.HOCRTag,"HOCRParagraph");
	}

	
}
