package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class AddressNavigationServlet
 */
@WebServlet("/addressNavigationServlet")
public class AddressNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressItemHelper dao = new AddressItemHelper();
		String path="/viewAllAddressesServlet";
		String act = request.getParameter("ChangeAddress");
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Address addressToDelete = dao.searchForAddressById(tempId);
				dao.deleteAddress(addressToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an address.");
			}
		}
		
		else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	
	}

}
