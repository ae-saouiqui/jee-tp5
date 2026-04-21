package controllers;

import javax.servlet.http.HttpSession;

import entities.User;
import services.UserService;
import services.UserServiceImpl;

public class UserController extends Command implements  Controller {

    UserService service;

    public UserController(){
        this.service = new UserServiceImpl();
    }

    @Override
    public String process() {
        String method = req.getMethod();
        return switch (method){
            case "GET" -> this.doGet();
            case "POST" -> this.doPost();
            default -> "redirect:/index.jsp";
        };
    }

    @Override
    public String doGet() {
        String action = req.getParameter("action");
        String view =  switch(action){
            case "logout"-> logout();
            default -> "home";
        };

        return view;
    }



    @Override
    public String doPost() {
        String action = req.getParameter("action");
        String view = switch(action){
            case "login" -> login();
            default -> "redirect:/index.jsp";
        };
        return view;
    }


    private String login(){
        String username = req.getParameter("username");
        String password  = req.getParameter("password");
        User user = service.login(username, password);
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            return "redirect:/Produit";
        }
        return "redirect:/index.jsp";
}

    private String logout(){
        HttpSession session = req.getSession(false);
        session.invalidate();
        return "redirect:/index.jsp";
    }

}
