package com.perfios.hocrToPDF;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HOCRToDataStructure {

	public static void main(String[] args) {
		String hocrString=readAllBytesJava7("/home/aniruddha/digitization/JSON/out.hocr");
		Document document = Jsoup.parse(hocrString);

		HOCRDocument root=new HOCRDocument(document);
		
	}
	private static String readAllBytesJava7(String filePath)
	{
		String content = "";

		try
		{
			content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return content;
	}

}
