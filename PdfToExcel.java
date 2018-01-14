package beans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PdfToExcel {

	public void getPdfToExcel(String sourcefilepath,String destinationfilepath) throws IOException
	{
		PdfReader reader = new PdfReader(sourcefilepath);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);        
        TextExtractionStrategy strategy;
        String line = null;
        List<String> lines = new ArrayList<String>();
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
            line = strategy.getResultantText();
            lines.add(new StringReader(line).toString());
        }
        reader.close();

        org.apache.poi.ss.usermodel.Workbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        System.out.println("link------->" + line);
        //List<String> lines = IOUtils.readLines(new StringReader(line), "UTF-8");

        for (int i = 0; i < lines.size(); i++) 
        {
            String str[] = lines.get(i).split(",");
            Row row = sheet.createRow((short) i);
            for (int j = 0; j < str.length; j++) 
            {
                row.createCell(j).setCellValue(helper.createRichTextString(str[j]));
            }
        }

        FileOutputStream fileOut = new FileOutputStream(destinationfilepath);
        wb.write(fileOut);
        fileOut.close();
	}
	
	
}
