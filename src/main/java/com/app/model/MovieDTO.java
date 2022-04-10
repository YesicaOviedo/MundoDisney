package com.app.model;

import java.util.Date;
import java.util.List;

public class MovieDTO {
	private String title;
	private Date date;
	private int rating;
	private List<Long> idsCharacters;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<Long> getIdsCharacters() {
		return idsCharacters;
	}
	public void setIdsCharacters(List<Long> idsCharacters) {
		this.idsCharacters = idsCharacters;
	}




}
