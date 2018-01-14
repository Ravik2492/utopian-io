package beans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
 
public class UserProfilePdf
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
         String userimagepath = context.getRealPath("/images/users/"+list.getUser_img_title()+"");
                           
         Image image2 = Image.getInstance(userimagepath);
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
         
         PdfPTable table = new PdfPTable(new float[] { 30, 25, 45 });
         table.setWidthPercentage(100);
         table.setSpacingBefore(10f); 
         table.setSpacingAfter(10f);
         
         PdfPCell imgcell = new PdfPCell(new Phrase(""));
         imgcell.setPaddingLeft(10);
         imgcell.setHorizontalAlignment(Element.ALIGN_CENTER);
         imgcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         imgcell.setBorder(Rectangle.NO_BORDER);
                    
         PdfPCell title1 = new PdfPCell();
         Phrase nametitle = new Phrase("Name: ",title);
         Phrase emailtitle = new Phrase("Email: ",title);
         Phrase mobiletitle = new Phrase("Mobile: ",title);
         Phrase gendertitle = new Phrase("Gender: ",title);
         Phrase ccitytitle = new Phrase("Current City: ",title);
         Phrase pincodetitle = new Phrase("Pin Code: ",title);
         title1.addElement(nametitle);
         title1.addElement(emailtitle);
         title1.addElement(mobiletitle);
         title1.addElement(gendertitle);
         title1.addElement(ccitytitle);
         title1.addElement(pincodetitle);
         title1.setPaddingLeft(10);
         title1.setHorizontalAlignment(Element.ALIGN_CENTER);
         title1.setVerticalAlignment(Element.ALIGN_MIDDLE);
         title1.setBorder(Rectangle.NO_BORDER);
  
         PdfPCell value1 = new PdfPCell();
         Phrase namevalue = new Phrase(list.getUser_name(),value);
         Phrase emailvalue = new Phrase(list.getUser_email(),value);
         Phrase mobilevalue = new Phrase(list.getUser_mobile().toString(),value);
         Phrase gendervalue = new Phrase(list.getUser_gender(),value);
         Phrase ccityvalue = new Phrase(list.getUser_current_city(),value);
         Phrase pincodevalue = new Phrase(list.getUser_current_city_pincode(),value);
         value1.addElement(namevalue);
         value1.addElement(emailvalue);
         value1.addElement(mobilevalue);
         value1.addElement(gendervalue);
         value1.addElement(ccityvalue);
         value1.addElement(pincodevalue);
         value1.setPaddingLeft(10);
         value1.setHorizontalAlignment(Element.ALIGN_CENTER);
         value1.setVerticalAlignment(Element.ALIGN_MIDDLE);
         value1.setBorder(Rectangle.NO_BORDER);      
  
         table.addCell(imgcell);
         table.addCell(title1);
         table.addCell(value1);
                  
         PdfPTable table1 = new PdfPTable(new float[] { 30, 70 });
         table1.setWidthPercentage(100);
         table1.setSpacingBefore(10f); 
         table1.setSpacingAfter(10f);
                             
         PdfPCell title2 = new PdfPCell();
         Phrase collegenametitle = new Phrase("College name: ",title);
         Phrase companynametitle = new Phrase("Company Name: ",title);
         Phrase hometowntitle = new Phrase("Home Town: ",title);
         Phrase citytitle = new Phrase("City: ",title);
         Phrase collegeaddresstitle = new Phrase("College Address: ",title);
         Phrase companyaddresstitle = new Phrase("Company Address: ",title);
         Phrase permanentaddresstitle = new Phrase("Permanent Address: ",title);
         Phrase countrytitle = new Phrase("Country: ",title);
         title2.addElement(collegenametitle);
         title2.addElement(companynametitle);
         title2.addElement(hometowntitle);
         title2.addElement(citytitle);
         title2.addElement(collegeaddresstitle);
         title2.addElement(companyaddresstitle);
         title2.addElement(permanentaddresstitle);
         title2.addElement(countrytitle);
         title2.setPaddingLeft(10);
         title2.setHorizontalAlignment(Element.ALIGN_CENTER);
         title2.setVerticalAlignment(Element.ALIGN_MIDDLE);
         title2.setBorder(Rectangle.NO_BORDER);
  
         PdfPCell value2 = new PdfPCell();
         Phrase collegenamevalue = new Phrase(list.getUser_college(),value);
         Phrase companynamevalue = new Phrase(list.getUser_company(),value);
         Phrase hometownvalue = new Phrase(list.getUser_hometown(),value);
         Phrase cityvalue = new Phrase(list.getUser_city(),value);
         Phrase collegeaddressvalue = new Phrase(list.getUser_college_address(),value);
         Phrase companyaddressvalue = new Phrase(list.getUser_company_address(),value);
         Phrase permanentaddressvalue = new Phrase(list.getUser_permanent_address(),value);
         Phrase countryvalue = new Phrase(list.getUser_country(),value);
         value2.addElement(collegenamevalue);
         value2.addElement(companynamevalue);
         value2.addElement(hometownvalue);
         value2.addElement(cityvalue);
         value2.addElement(collegeaddressvalue);
         value2.addElement(companyaddressvalue);
         value2.addElement(permanentaddressvalue);
         value2.addElement(countryvalue);         
         value2.setPaddingLeft(10);
         value2.setHorizontalAlignment(Element.ALIGN_CENTER);
         value2.setVerticalAlignment(Element.ALIGN_MIDDLE);
         value2.setBorder(Rectangle.NO_BORDER); 
           
         table1.addCell(title2);
         table1.addCell(value2);
  
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