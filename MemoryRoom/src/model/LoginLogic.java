package model;

import bean.User;

public class LoginLogic {
	public boolean isExecute(User user) {
		if (user.getKey().equals("1224")){
			return true;}
		return false;
	}
		
}
