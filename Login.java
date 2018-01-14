package beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Login {
	
	HttpSession httpSession = null;
	
	public String doLogin()
	{
		String userid = "administrator";
		String usertype = "Master Admin";
		
		httpSession.setAttribute("userid", userid);
		httpSession.setAttribute("usertype", usertype);
		
		//for access control list
		List<UserSetting> settings = new ArrayList<UserSetting>();
		settings.add(new UserSetting(1,true,true,true,false));
		settings.add(new UserSetting(1,true,false,true,false));
		
		UserSetting usersetting = null;
		httpSession.setAttribute("usersetting", usersetting);
		
		return "success";
	}
	
	public String findSession()
	{
		String msg = "";
		String userid = (String) httpSession.getAttribute("userid");
		String usertype = (String) httpSession.getAttribute("usertype");
		if(userid==null)
		{
			msg = "loginfailed";
		}
		else
		{
			if(!usertype.equals("Master Admin"))
			{
				msg = "loginfailed";
			}
			else
			{
				msg = "success";
			}
		}
		return msg;
	}
	
	public UserSetting getSetting()
	{
		return (UserSetting) httpSession.getAttribute("usersetting");
	}
}
