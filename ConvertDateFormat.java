package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateFormat {
	
	public String getDateFromDataBase(Date date) throws ParseException
	{
		String newdate = "";
		newdate = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
		return newdate;
	}

}
