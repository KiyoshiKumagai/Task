package dto;

public class Dto {
	private String content;
	private int id;
	private int year;
	private int month;
	private int day;
	private int judgment;
	private int money;
	//saerch
	public Dto(String content, int id, int year, int month, int day, int judgment, int money) {
		this.content = content;
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.judgment = judgment;
		this.money = money;
	}
	//insert
	public Dto(String content, int year, int month, int day, int judgment, int money) {
		this.content = content;
		this.year = year;
		this.month = month;
		this.day = day;
		this.judgment = judgment;
		this.money = money;
	}
	//delete
	public Dto(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getJudgment() {
		return judgment;
	}
	public void setJudgment(int judgment) {
		this.judgment = judgment;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}


}
