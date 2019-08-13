package com.perfios.hocrToPDF;

import org.jsoup.nodes.Element;

public class HOCRLine extends HOCRElement{
	public HOCRLine(Element parent,Element hOCRHtml) {
		super(hOCRHtml, parent,"span",HOCRWord.HOCRTag,"HOCRWord");
	}

	public static final String HOCRTag="ocr_line";
}
