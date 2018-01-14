package beans;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ListToJsonObject {
	
	public String getJson(List list) throws JsonGenerationException, JsonMappingException, IOException
	{
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(list);
		return json;
	}
	
	public String toJson(DataTablesTO<?> list) throws JsonGenerationException, JsonMappingException, IOException
	{
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(list);
		return json;
	}

}
