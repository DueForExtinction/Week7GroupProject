package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class EditAddressServlet
 */
@WebServlet("/editAddressServlet")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		AddressItemHelper dao = new AddressItemHelper();
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Integer tempid = Integer.parseInt(request.getParameter("id"));
		
		Address addressToUpdate = dao.searchForAddressById(tempid);
		addressToUpdate.setStreet(street);
		addressToUpdate.setCity(city);
		addressToUpdate.setState(state);
		addressToUpdate.setZip(zip);
		
		dao.updateAddress(addressToUpdate);
		getServletContext().getRequestDispatcher("/viewAllAddressesServlet").forward(request, response);
	}

}
