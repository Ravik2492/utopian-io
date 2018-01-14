package beans;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.LogFileModel;

public class LogFileCreationUtils {
	
	public void createLogFile(List<LogFileModel> list,String filepath,String filename) throws IOException
	{		
		String path = filepath + filename + ".csv";
		
		File f = new File(path);
		if(!f.exists())
		{
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f,true);
		
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				fw.append(String.valueOf(list.get(i).getSrno()));
				fw.append(",");
				fw.append(String.valueOf(list.get(i).getUser_id()));
				fw.append(",");
				fw.append(list.get(i).getDate());
				fw.append(",");
				fw.append(list.get(i).getMessage());
				fw.append("\n");
			}
		}
		fw.flush();
		fw.close();
	}
}
