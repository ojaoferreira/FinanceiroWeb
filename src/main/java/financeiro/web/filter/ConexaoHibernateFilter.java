package financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import financeiro.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {
	private SessionFactory sf;
<<<<<<< HEAD

	public void init(FilterConfig filterConfig) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
=======
	
	public void destroy() {
		
>>>>>>> master
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		try {
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
<<<<<<< HEAD
		} catch (Throwable ex) {
=======
		} catch(Throwable ex) {
>>>>>>> master
			try {
				if(this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
<<<<<<< HEAD
			} catch (Exception t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

	public void destroy() {	}
=======
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException();
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}
>>>>>>> master
}
