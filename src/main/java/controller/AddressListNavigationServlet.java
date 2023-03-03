package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDetails;

/**
 * Servlet implementation class AddressListNavigationServlet
 */
@WebServlet("/addressListNavigationServlet")
public class AddressListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressDetailsHelper dao = new AddressDetailsHelper();
		String act = request.getParameter("DoThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllAddressListsServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			AddressDetails addressToDelete = dao.searchForAddressDetailsById(tempId);
			dao.deleteAddressList(addressToDelete);
			}
			catch(NumberFormatException e){
				System.out.println("forgot to click a button");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllAddressListsServlet").forward(request, response);
			}
		}
	}

}
