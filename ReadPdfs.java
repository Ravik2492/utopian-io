package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ReadPdfs {
	
		
	public static void main(String ar[]) throws IOException
	{
		String name =" ", email=" ", ccity=" ", mobileno=" ", gender = " ";
		
		String numbers[] = new String[70];
		String path = "F:/Ravi.pdf";
		
		new PdfToExcel().getPdfToExcel("F:/Ravi.pdf", "F:/Ravi.xls");
		
		String textfrompdf = "";
		
		PdfReader reader = new PdfReader(path);
		
		int pages = reader.getNumberOfPages();
				
		for(int i=0;i<pages;i++)
		{
			textfrompdf = PdfTextExtractor.getTextFromPage(reader, 1);
		}
						
		StringTokenizer st = new StringTokenizer(textfrompdf.replaceAll("\\s", " ")," ");
		int j=0;
		while(st.hasMoreTokens())
		{
			numbers[j] = st.nextToken();
			j++;
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<numbers.length;i++)
		{
			//System.out.println("index "+i+":  "+numbers[i]);
			if(numbers[i]!=null)
			{
				if(numbers[i].equals("Profile") && numbers[i+1].equals("Name:"))
				{
					name = numbers[i+2] +" "+numbers[i+3];
				}
				
				if(numbers[i].equals("Email:"))
				{
					email = numbers[i+1];
				}
				
				if(numbers[i].equals("Mobile:"))
				{
					mobileno = numbers[i+1];
				}
				
				if(numbers[i].equals("Gender:"))
				{
					gender = numbers[i+1];
				}
				
				if(numbers[i].equals("Current") && numbers[i+1].equals("City:"))
				{
					ccity = numbers[i+2];
				}			
			}
		}
		
		list.add(name);
		list.add(email);
		list.add(mobileno);
		list.add(gender);
		list.add(ccity);
		
		for(int i=0;i<list.size();i++)
		{
		System.out.println(list.get(i));
		}
	}
}
