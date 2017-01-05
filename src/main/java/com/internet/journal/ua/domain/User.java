package com.internet.journal.ua.domain;

public class User {
	private int id;
	private String name;
	private String nick;
	private int age;
	private boolean isDelited;

	public User() {
	}

	public User(int id, String name, String nick, int age, boolean isDelited) {
		super();
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.age = age;
		this.isDelited = isDelited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isDelited() {
		return isDelited;
	}

	public void setDelited(boolean isDelited) {
		this.isDelited = isDelited;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nick=" + nick + ", age=" + age + ", isDelited=" + isDelited
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + (isDelited ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (isDelited != other.isDelited)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}

}
