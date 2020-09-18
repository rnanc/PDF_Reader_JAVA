package br.com.cesupa.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Main {
	
	//TEXT EXTRACT
	
	 static String getText(File pdfFile) throws IOException {	  
		 PDDocument doc = PDDocument.load(pdfFile); return new
		PDFTextStripper().getText(doc); 
	 }
	//END
	public static void main(String[] args) throws IOException, TesseractException {
		
		//OCR
		
		 String text;
		 PDFTextStripper reader = new PDFTextStripper();
		 Tesseract instance = new Tesseract();
		 instance.setLanguage("por");
		 instance.setDatapath("C:\\Users\\renan\\git\\PDF_Reader_JAVA\\PdfReader\\tessdata");
		 try { 
			//text = getText(new File("D:\\Downloads\\Processo_0000315-12.2018.5.08.0208.pdf"));
			//System.out.println(text); 
			 PDDocument doc = PDDocument.load(new File("D:\\Downloads\\Retoma_Para_16_09.pdf"));
			 //int numero = doc.getNumberOfPages();
			 //System.out.println(numero);
			 for (int i = 0; i <= doc.getNumberOfPages(); i++) {
				 reader.setStartPage(i);
				 reader.setEndPage(i);
				 //reader.getText(doc);
			 if (reader.getText(doc).contains("CAPÍTULO III")) {
					 System.out.println(reader.getText(doc));
					 System.out.println("PDFREADER");
				}
				 if (reader.getText(doc).contains("CAPÍTULO III") ) {
					// System.out.println(reader.getText(doc));
					 PDFRenderer renderer = new PDFRenderer(doc);
					 BufferedImage image = renderer.renderImageWithDPI(i - 1, 300);
					 //ImageIO.write(image, "JPEG", new File("D:\\Downloads\\texto.jpg"));
					 //File file = new File("D:\\Downloads\\texto.jpg");
					 String result = instance.doOCR(image);
					 System.out.println(result);
					 System.out.println("ORC");
				 }
			 }
			 doc.close();
		 } 
		 catch (IOException e) {
			 //e.printStackTrace();
		 }
		 
		//END
	}
	
	
}
