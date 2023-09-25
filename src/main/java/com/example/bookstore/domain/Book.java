package com.example.bookstore.domain;

public class Book {
private String title;
private String author;
private String publicationYear;
private String isbn;
private int price;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublicationYear() {
	return publicationYear;
}
public void setPublicationYear(String publicationYear) {
	this.publicationYear = publicationYear;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
