package com.perfios.hocrToPDF;

import org.jsoup.nodes.Element;

public class HOCRWord extends HOCRElement{
	public HOCRWord(Element parent,Element hOCRHtml) {
		super(hOCRHtml, parent,null,null,null);
	}

	public static final String HOCRTag="ocrx_word";
}
