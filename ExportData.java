package beans;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

public class ExportData {
	
	public void exportAllFileData(String path,List list,String filetype,String filename,HttpServletResponse response)
	{
		JasperPrint jasperPrint;
		
		ServletOutputStream outputStream = null;
		try
		{
			JRBeanCollectionDataSource result=new JRBeanCollectionDataSource(list);
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String,Object>(), result);
			
			if(filetype.equals("PDF"))
			{
				response.setHeader("Content-Disposition", "attachment;filename="+filename+".pdf");
				response.setContentType("application/octet-stream");
				outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			}
			if(filetype.equals("EXCEL"))
			{
				response.setHeader("Content-Disposition", "attachment;filename="+filename+".xlsx");
				response.setContentType("application/octet-stream");
				outputStream = response.getOutputStream();
				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				exporter.exportReport();
			}
			if(filetype.equals("DOC"))
			{
				response.setHeader("Content-Disposition", "attachment;filename="+filename+".docx");
				response.setContentType("application/octet-stream");
				outputStream = response.getOutputStream();
				JRDocxExporter exporter = new JRDocxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				exporter.exportReport();
			}
			if(filetype.equals("CSV"))
			{
				response.setHeader("Content-Disposition", "attachment;filename="+filename+".csv");
				response.setContentType("application/octet-stream");
				outputStream = response.getOutputStream();
				JRCsvExporter exporter = new JRCsvExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				exporter.exportReport();
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}