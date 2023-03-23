package com.kaiburrassessment.kaiburrassessment.entities;

public class Server {
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Server(String name, String id, String language, String framework) {
		super();
		this.name = name;
		this.id = id;
		this.language = language;
		this.framework = framework;
	}
	private String name;
	private String id;
	@Override
	public String toString() {
		return "Server [name=" + name + ", id=" + id + ", language=" + language + ", framework=" + framework
				+ ", getName()=" + getName() + ", getId()=" + getId() + ", getLanguage()=" + getLanguage()
				+ ", getFramework()=" + getFramework() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	private String language;
	private String framework;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	
}
