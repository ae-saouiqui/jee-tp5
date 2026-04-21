package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class  Command  {
    protected HttpServletRequest req;
    protected HttpServletResponse rep;
    protected ServletContext context;

    public void init(HttpServletRequest req,HttpServletResponse rep,ServletContext context){
        this.req = req;
        this.rep = rep;
        this.context = context;
    }

    public abstract String process();
}
