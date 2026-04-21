package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Roles;
import entities.User;

@WebFilter("/Produit")
public class RoleFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        boolean isAdmin = user.getRole() == Roles.ADMIN;
        String action = req.getParameter("action");
            if(action!=null){
                switch (action){
                case "editPrdouit","addProduit","updateProduit","deleteProduit" -> {
                    if(isAdmin) {
                        chain.doFilter(request, response);
                    }
                    else {
                        resp.sendRedirect(req.getContextPath()+"/Produit?action=getProduit");
                    }
                }
                default  -> chain.doFilter(request,response);
            };
        }else  chain.doFilter(request, response);
    }
        
    @Override
    public void destroy() {
    }
}
