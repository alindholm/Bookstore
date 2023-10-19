package com.example.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Gategory {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long gategoryid;


public Long getGategoryid() {
	return gategoryid;
}

public void setGategoryid(Long gategoryid) {
	this.gategoryid = gategoryid;
}

private String name;

@OneToMany(cascade=CascadeType.ALL, mappedBy="gategory")
private List<Book> book;

public List<Book> getBook() {
	return book;
}

public void setBook(List<Book> book) {
	this.book = book;
}

public Gategory() {}

public Gategory(String name) {
	super();
	this.setName(name);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Gategory [gategoryid=" + gategoryid + ", name=" + name + "]";
}
}
