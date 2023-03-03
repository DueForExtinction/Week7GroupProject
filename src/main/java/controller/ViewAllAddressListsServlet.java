package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDetails;



/**
 * Servlet implementation class ViewAllAddressListsServlet
 */
@WebServlet("/viewAllAddressListsServlet")
public class ViewAllAddressListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAddressListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressDetailsHelper ald = new AddressDetailsHelper();
		List<AddressDetails> abc = ald.getDetails();
		request.setAttribute("currentAddressList", abc);
		
		if(abc.isEmpty()) {
			request.setAttribute("currentAddressList", " ");
		}
		
		getServletContext().getRequestDispatcher("/Address-List-By-User.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
