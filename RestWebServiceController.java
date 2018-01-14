package com.blog.restwebservice;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.blog.bean.QuestionsBean;
import beans.ConvertDateFormat;
import beans.ListToJsonObject;
import beans.Sudent;

import com.blog.model.Questions;
import com.blog.service.QuestionsService;

@RestController
@RequestMapping("/yayayaa")
public class RestWebServiceController {
	@Autowired(required=false)
	private QuestionsService questionsService;
	
	ListToJsonObject listtojson = new ListToJsonObject();
	ConvertDateFormat fmt = new ConvertDateFormat();
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String listQuestionsss() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
				
		List<QuestionsBean> mybean = prepareListofBean(questionsService.listQuestionss());		
		
		List<Sudent> list = listofStudents();
						
		String json = listtojson.getJson(mybean);
		System.out.println("REST");
		System.out.print(json);
		//combination of both json objects...
		json = json + listtojson.getJson(list);
		return json;
	}
		
	
		
	private List<QuestionsBean> prepareListofBean(List<Questions> questionss){
		List<QuestionsBean> beans = null;
		if(questionss != null && !questionss.isEmpty()){
			beans = new ArrayList<QuestionsBean>();
			QuestionsBean bean = null;
			for(Questions questions : questionss){
				bean = new QuestionsBean();
				bean.setQuestion_id(questions.getQuestion_id());
				bean.setQuestion_name(questions.getQuestion_name());
				bean.setQuestion_email(questions.getQuestion_email());
				bean.setQuestion_title(questions.getQuestion_title());
				bean.setQuestion_content(questions.getQuestion_content());
				bean.setQuestion_date(questions.getQuestion_date());
				beans.add(bean);
			}
		}
		return beans;
	}	
	
	List<Sudent> list = new ArrayList<Sudent>();
	public List<Sudent> listofStudents()
	{
		list.add(new Sudent(1,20,"Rahul","Whatever","rahul@gmail.com"));
		list.add(new Sudent(2,21,"Ramesh","Whatever","ramesh@gmail.com"));
		list.add(new Sudent(3,22,"Shyam","Whatever","shyam@gmail.com"));
		list.add(new Sudent(4,23,"Ram","Whatever","ram@gmail.com"));
		list.add(new Sudent(5,24,"Krishna","Whatever","krishna@gmail.com"));
		list.add(new Sudent(6,25,"Jacop","Whatever","jacop@gmail.com"));
		
		return list;
	}
}