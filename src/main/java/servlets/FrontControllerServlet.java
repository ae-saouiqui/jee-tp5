package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dispatchers.Dispatcher;


@WebServlet("/")
public class FrontControllerServlet  extends HttpServlet{

    public static Dispatcher dispatcher;

    @Override
    public void init() throws ServletException {
        dispatcher =  new Dispatcher(getServletContext());
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatcher.dispatch(req, resp);
    }
}
