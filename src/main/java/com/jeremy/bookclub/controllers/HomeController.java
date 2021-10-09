package com.jeremy.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeremy.bookclub.models.Book;
import com.jeremy.bookclub.models.LoginUser;
import com.jeremy.bookclub.models.User;
import com.jeremy.bookclub.services.BookService;
import com.jeremy.bookclub.services.UserService;


@Controller
public class HomeController {
    
	@Autowired
	private UserService userServ;
    @Autowired
    private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        if(session.getAttribute("user_id") != null) {
        	
        	return "redirect:/home";
        }
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    @RequestMapping("/home")
    public String home(Model model,HttpSession session ) {
    	Long id = (Long) session.getAttribute("user_id");
    	User user = userServ.findOne(id);
    	List<Book> books =  bookServ.findAll();
    	model.addAttribute("user", user);
    	model.addAttribute("books", books);
    	return "home.jsp";
    	
    }
    @RequestMapping("/add/book")
    public String addBookView(@ModelAttribute("book") Book book, HttpSession session ) {
    
    	return "addBook.jsp";
    	
    }
    @RequestMapping("/edit/book/{id}")
    public String editBookView(@ModelAttribute("book") Book book, HttpSession session, Model model,  @PathVariable("id") Long id ) {
    	Book oneBook = bookServ.findOne(id);
    	model.addAttribute("oneBook", oneBook);
    	return "editBook.jsp";
    	
    }
    @RequestMapping("/edits/book/{id}")
    public String editBook(Model model,@PathVariable("id") Long id , @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session ) {
    	if (result.hasErrors()) {
    		Book oneBook = bookServ.findOne(id);
    		model.addAttribute("oneBook" , oneBook);
	    	model.addAttribute("book");
			return "editBook.jsp";
		}
    	Long uId = (Long) session.getAttribute("user_id");
    	User user = userServ.findOne(uId);
    	book.setUser(user);
    	bookServ.create(book);
    	return "redirect:/home";	
    }
    @PostMapping("/add/book")
    public String addBookAction(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
    	if (result.hasErrors()) {
	
	    	model.addAttribute("book");
			return "addBook.jsp";
		}
    	
    	Long id = (Long) session.getAttribute("user_id");
    	User user = userServ.findOne(id);
    	book.setUser(user);
  		bookServ.create(book);
  		return "redirect:/home";
 
    }
    @GetMapping("view/book/{id}")
    public String viewBook (Model model, HttpSession session, @PathVariable("id") Long id) {
    	Long uId = (Long) session.getAttribute("user_id");
    	User user = userServ.findOne(uId);
    	Book book = bookServ.findOne(id);
    	model.addAttribute(book);
    	model.addAttribute(user);
    	
    	return "viewBook.jsp";
    }
   @RequestMapping("logout")
    public String logout (HttpSession session) {
	   	session.invalidate();
    	return "redirect:/";
    }
   
    
    
}