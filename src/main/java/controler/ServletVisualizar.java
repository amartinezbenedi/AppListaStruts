package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AparcamientosPublicosDAO;
import model.vo.AparcamientosPublicosVO;

/**
 * Servlet implementation class ServletVisualizar
 */
public class ServletVisualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AparcamientosPublicosDAO apDAO = new AparcamientosPublicosDAO();
	AparcamientosPublicosVO apVO = new AparcamientosPublicosVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int id =  Integer.parseInt((String) sesion.getAttribute("id"));
		HttpSession sesion = request.getSession(true);
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		
		try{
		apVO = apDAO.detalleAparcamientos(id);
		request.setAttribute("apVO", apVO);
		request.getRequestDispatcher("PaginaVisualizar.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
