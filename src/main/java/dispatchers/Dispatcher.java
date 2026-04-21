package dispatchers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.Command;



public class Dispatcher {

    private ServletContext context;

    public Dispatcher(ServletContext context ){
        this.context = context;
    }


    private Command getCommand(HttpServletRequest req) {
        String module = context.getInitParameter("commandPackage");
        String name = getCommandName(req);
        Command controller = null;
        try {
            Class <?> cl = Class.forName(module +"." + name +"Controller");
            controller = (Command) cl.asSubclass(Command.class) // asSubclass() : cast the objet to subclass of the superclass type if it exists
            .getConstructor()
            .newInstance(); 

        }catch(ClassNotFoundException cfe){
            System.out.println("Class"+name+"Not Found");
        }catch (ClassCastException cce){
            System.out.println("Class"+name+"is Not a subclass");
        }catch( InstantiationException | IllegalAccessException | 
             InvocationTargetException |NoSuchMethodException e){
            System.out.println("Cannot instanciate "+name);
        }
        return controller;
    }

    private String getCommandName(HttpServletRequest req){
        String uri = req.getRequestURI();
        String name =  uri.substring(uri.lastIndexOf("/") + 1 );
        return name;
    }

    public void dispatch(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
        Command controller = getCommand(req);
        if(controller == null){
            HandleError(req, resp, "Page "+getCommandName(req)+" Not Found");
            return;
        }
        controller.init(req, resp, context);
        String result = controller.process();
        if(result.startsWith("redirect:")){
            String view = result.split("redirect:")[1];
            resp.sendRedirect(req.getContextPath() + view);
        }else {
            String view  =  resloveView(result);
            RequestDispatcher dispatcher = req.getRequestDispatcher(view);
            dispatcher.forward(req, resp);
        }
    }

    private String resloveView(String view){
        String views = context.getInitParameter("viewsPath");
        return views + "/" + view + ".jsp" ;
    }

    private void HandleError(HttpServletRequest req,HttpServletResponse resp,String message) throws ServletException,IOException{
        req.setAttribute("message", message);
        RequestDispatcher rd = req.getRequestDispatcher(resloveView("error"));
        rd.forward(req, resp);
    }
}
