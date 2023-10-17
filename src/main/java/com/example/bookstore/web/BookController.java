package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@GetMapping(value= {"/booklist"})
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());return "booklist";
	}
	@GetMapping("/addbook")
    public String showAddBookForm() {
        return "addbook";}
	@RequestMapping(value = "/add")
	public String addStudent(Model model){
	 model.addAttribute("student", new Book());
	 return "addstudent";
	}
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
	    repository.save(book);
	    return "redirect:/booklist";
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable Long id) {
	    repository.deleteById(id);
	    return "redirect:/booklist";
	}
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
	    // Retrieve the book by ID from the repository
		Book book = repository.findById(id).orElse(null);	    
		model.addAttribute("book", book);
	    return "editbook";
	}
	@PostMapping("/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book editedBook) {
	    Book existingBook = repository.findById(id).orElse(null);
	        existingBook.setTitle(editedBook.getTitle());
	        existingBook.setAuthor(editedBook.getAuthor());
	        existingBook.setYear(editedBook.getYear());
	        existingBook.setIsbn(editedBook.getIsbn());
	        existingBook.setPrice(editedBook.getPrice());
	        repository.save(existingBook);
	    return "redirect:/booklist";
	}

}
