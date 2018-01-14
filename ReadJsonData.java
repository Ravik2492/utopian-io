package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class ReadJsonData {
	
	public String readJsonData(String filepath) throws IOException
	{
		String jsondata = IOUtils.toString(new FileInputStream(filepath));
		return jsondata;
	}
	
	public static void main(String args[]) throws IOException
	{
		String filepath = "F:/nuclear.txt";
		
		String jsondata = new ReadJsonData().readJsonData(filepath);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Energy> energy = new ArrayList<Energy>();
				
		HashMap<String,HashMap<String,Object>> mymap = mapper.readValue(jsondata, HashMap.class);
				
		for (Entry<String, HashMap<String,Object>> entry : mymap.entrySet()) {
			String state = entry.getKey();
		    HashMap<String,Object> data = entry.getValue();
		    energy.add(new Energy(state,data.get("Nuclear").toString(),data.get("Renewables").toString(),data.get("Thermal").toString(),data.get("Hydro").toString(),data.get("Grand Total").toString()));
		}
		
		for(int i=0;i<energy.size();i++)
		{
			System.out.println("State : "+energy.get(i).getState());
			System.out.println("Nuclear : "+energy.get(i).getNuclear());
			System.out.println("Thermal : "+energy.get(i).getThermal());
			System.out.println("Hydro : "+energy.get(i).getHydro());
			System.out.println("Renewals : "+energy.get(i).getRenewables());
			System.out.println("Grand Total : "+energy.get(i).getGrandtotal());			
		}
		
		
	}

}
