package com.perfios.hocrToPDF;

import java.util.List;

import org.jsoup.nodes.Element;

public class HOCRParagraph extends HOCRElement{
	public HOCRParagraph(Element parent,Element hOCRHtml) {
		super(hOCRHtml, parent,"span",HOCRLine.HOCRTag,"HOCRLine");
	}

	public static final String HOCRTag="ocr_par";
}
