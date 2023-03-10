package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.AddressDetails;
import model.AddressList;

/**
 * Servlet implementation class CreateNewAddressListServlet
 */
@WebServlet("/createNewAddressListServlet")
public class CreateNewAddressListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAddressListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressItemHelper aih = new AddressItemHelper();
		
		String detailsName = request.getParameter("detailsName");
		System.out.println("List name: " + detailsName + " from CNALS");
		
		String resident = request.getParameter("resident");
		System.out.println(resident + " CNALS");
		
		String month = request.getParameter("month");
		String day= request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			System.out.println(ld);
		}
		catch(NumberFormatException ex) {
			ld=LocalDate.now();
		}
		
		String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
		
		List<Address> selectedAddressesInList = new ArrayList<Address>();
		
		if(selectedAddresses != null && selectedAddresses.length > 0) {
			for(int i= 0; i<selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				Address a = aih.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
				System.out.println(a.toString());
				selectedAddressesInList.add(a);
			}
		}
		else if(selectedAddresses == null) {
			System.out.println("Yo this shit empty!");
		}
		
		AddressList al = new AddressList(resident);
		AddressDetails ad = new AddressDetails(detailsName, ld, al);
		
		ad.setListOfAddresses(selectedAddressesInList);
		AddressDetailsHelper adh = new AddressDetailsHelper();
		adh.insertNewAddressDetails(ad);
		
		System.out.println("Success!");
		System.out.println(adh.toString());
		
		getServletContext().getRequestDispatcher("/viewAllAddressListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
