package com.example.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private double price;

	@ManyToOne
	@JoinColumn(name = "gategoryid")
	private Gategory gategory;

	@Column(name = "book_year")
	private int year;

	public Book() {
	}

	public Book(String title, String author, int year, String isbn, double price, Gategory gategory) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.gategory = gategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Gategory getGategory() {
		return gategory;
	}

	public void setGategory(Gategory gategory) {
		this.gategory = gategory;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		if (this.gategory != null)
			return "Book=[ id=" + id + ", title=" + title + "gategory=" + this.getGategory() + "]";
		else
			return "Book=[ id=" + id + ", title=" + title + "]";
	}
}
