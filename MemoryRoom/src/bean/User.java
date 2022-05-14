package bean;

import java.io.Serializable;

public class User implements Serializable{
	private String name;		// ユーザー名
	private String key;		// パスワード
	public User(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public String getKey() {
		return key;
	}

}
