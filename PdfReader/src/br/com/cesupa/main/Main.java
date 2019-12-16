package br.com.cesupa.main;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class Main {
	
	//USA TEXT EXTRACT
	
	 static String getText(File pdfFile) throws IOException {	  
		 PDDocument doc = PDDocument.load(pdfFile); return new
		PDFTextStripper().getText(doc); 
	 }
	//END
	public static void main(String[] args) throws IOException {
		
		
		//USA TEXT EXTRACT
		
		 String text;
		  
		 try { text = getText(new
		 File("path to pdf file"));
		 System.out.println(text); } catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		//END
	}
	
	
}
