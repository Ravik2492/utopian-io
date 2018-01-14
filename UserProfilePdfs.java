package beans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.UsersBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
 
public class UserProfilePdfs
{
	private static String USER_PASSWORD = "password";
	private static String OWNER_PASSWORD = "ravi";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font title = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font value = new Font(Font.FontFamily.TIMES_ROMAN, 16);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	
   public void exportUserProfile(UsersBean list, String filename,HttpServletRequest req, HttpServletResponse response) throws MalformedURLException, IOException
   {
      Document document = new Document();
      try
      {
    	 response.setHeader("Content-Disposition", "attachment;filename="+filename+"_Profile.pdf");
		 response.setContentType("application/octet-stream");
         PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());                  
         //writer.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(),PdfWriter.ALLOW_PRINTING ,PdfWriter.ENCRYPTION_AES_128);
         document.open();
         document.addAuthor("TechBlogger Development Team");
         document.addCreationDate();
         document.addCreator("TechBlogger");
         document.addTitle(""+list.getUser_name()+" Profile");
         document.addSubject(""+list.getUser_name()+" Profile");
         
         PdfContentByte canvas = writer.getDirectContent();
         Rectangle rect = new Rectangle(36, 36, 559, 806);
         rect.setBorder(Rectangle.BOX);
         rect.setBorderWidth(2);
         canvas.rectangle(rect);
         
         ServletContext context = req.getServletContext();
 		 String path = context.getRealPath("/images/favicon.png");
         Image image1 = Image.getInstance(path);
         image1.setAbsolutePosition(50f, 770f);
         image1.scaleAbsolute(25, 25);
         document.add(image1);
         String imageUrl = "http://www.srfoodbareilly.com/ravi.jpg";
                  
         Image image2 = Image.getInstance(new URL(imageUrl));
         image2.setAbsolutePosition(50f, 610f);
         image2.scaleAbsolute(140, 140);
         image2.setBorder(Rectangle.BOX);   
         image2.setBorderWidth(5);
         document.add(image2);
         
         Paragraph titlepara = new Paragraph(" "+list.getUser_name()+" TechBlogger Profile", catFont);         
         titlepara.breakUp();
         LineSeparator line = new LineSeparator();
         line.setOffset(-10);
         titlepara.add(line);
         titlepara.setAlignment(Element.ALIGN_CENTER);         
         Paragraph emptypara = new Paragraph("");
         emptypara.breakUp();
         LineSeparator line2 = new LineSeparator();
         line2.setOffset(5);
         emptypara.add(line2);
         titlepara.setAlignment(Element.ALIGN_CENTER);
         
         List<String> list1 = new ArrayList<String>();
         
         list1.add("Name:         "+ list.getUser_name());
         list1.add("Email:        "+ list.getUser_email());
         list1.add("Mobile:       "+ list.getUser_mobile().toString());
         list1.add("Gender:       "+ list.getUser_gender());
         list1.add("Current City: "+ list.getUser_current_city());
         list1.add("Pin Code:     "+ list.getUser_current_city_pincode());
         
         List<String> list2 = new ArrayList<String>();
         
         list2.add("College Name:      "+ list.getUser_college());
         list2.add("Company Name:      "+ list.getUser_company());
         list2.add("Home Town:         "+ list.getUser_hometown());
         list2.add("City:              "+ list.getUser_city());
         list2.add("College Address:   "+ list.getUser_college_address());
         list2.add("Company Address:   "+ list.getUser_company_address());
         list2.add("Permanent Address: "+ list.getUser_permanent_address());
         list2.add("Country:           "+ list.getUser_country());
         
         PdfPTable table = new PdfPTable(new float[] { 30, 70 });
         table.setWidthPercentage(100);
         table.setSpacingBefore(10f); 
         table.setSpacingAfter(10f);
         
         PdfPCell imgcell = new PdfPCell(new Phrase(""));
         imgcell.setPaddingLeft(10);
         imgcell.setHorizontalAlignment(Element.ALIGN_CENTER);
         imgcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         imgcell.setBorder(Rectangle.NO_BORDER);
                    
         PdfPCell title1 = new PdfPCell();
         for(int i=0; i<list1.size();i++)
         {
         Phrase nametitle = new Phrase(list1.get(i).toString(),title);
         title1.addElement(nametitle);
         }
         title1.setPaddingLeft(10);
         title1.setHorizontalAlignment(Element.ALIGN_CENTER);
         title1.setVerticalAlignment(Element.ALIGN_MIDDLE);
         title1.setBorder(Rectangle.NO_BORDER);    
  
         table.addCell(imgcell);
         table.addCell(title1);
                  
         PdfPTable table1 = new PdfPTable(new float[] { 100 });
         table1.setWidthPercentage(100);
         table1.setSpacingBefore(10f); 
         table1.setSpacingAfter(10f);
                             
         PdfPCell title2 = new PdfPCell();
         for(int i=0; i<list2.size();i++)
         {
         Phrase collegenametitle = new Phrase(list2.get(i).toString(),title);
         title2.addElement(collegenametitle);
         }
         title2.setPaddingLeft(10);
         title2.setHorizontalAlignment(Element.ALIGN_CENTER);
         title2.setVerticalAlignment(Element.ALIGN_MIDDLE);
         title2.setBorder(Rectangle.NO_BORDER);
           
         table1.addCell(title2);
  
         document.add(titlepara);
         document.add(table);
         document.add(emptypara);
         document.add(table1);
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
   }
}
