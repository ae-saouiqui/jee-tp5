package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtils;

@WebFilter({
    "/User",
    "/Produit"
})
public class HibernateSessionFilter implements  Filter{

    private SessionFactory factory;
    private Transaction tx;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        factory = HibernateUtils.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            tx = factory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            tx.commit();
        } catch (Exception e) {
        e.printStackTrace(); 
        throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
        if(factory!= null) factory.close();
    }

}
