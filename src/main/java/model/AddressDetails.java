/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Chance
 *
 */
@Entity
public class AddressDetails {
	@Id
	@GeneratedValue
	private int id;
	private String detailsName;
	private LocalDate accessDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private AddressList adList;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	public AddressDetails() {
		super();
	}
	
	public AddressDetails(int id, String detailsName, LocalDate accessDate, AddressList adList, List<Address> listOfAddresses) {
		super();
		this.id = id;
		this.detailsName = detailsName;
		this.accessDate = accessDate;
		this.adList = adList;
		this.listOfAddresses = listOfAddresses;
	}
	
	public AddressDetails(String detailsName, LocalDate accessDate, AddressList adList, List<Address> listOfAddresses) {
		super();
		this.detailsName = detailsName;
		this.accessDate = accessDate;
		this.adList = adList;
		this.listOfAddresses = listOfAddresses;
	}
	
	public AddressDetails(String detailsName, LocalDate accessDate, AddressList adList) {
		super();
		this.detailsName = detailsName;
		this.accessDate = accessDate;
		this.adList = adList;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public String getDetailsName() {
		return detailsName;
	}
	
	public void setDetailsName(String newDetailsName) {
		this.detailsName = newDetailsName;
	}
	
	public LocalDate getAccessDate() {
		return accessDate;
	}
	
	public void setAccessDate(LocalDate newAccessDate) {
		this.accessDate = newAccessDate;
	}
	
	public AddressList getAddressList() {
		return adList;
	}
	
	public void setAddressList(AddressList newAdList) {
		this.adList = newAdList;
	}
	
	public List<Address> getListOfAddresses(){
		return listOfAddresses;
	}
	
	public void setListOfAddresses(List<Address> newList) {
		this.listOfAddresses = newList;
	}
	
	@Override
	public String toString() {
		System.out.println("AddressDetails= [id:" + id + ", detailsName:" + detailsName + ", accessDate:" + accessDate + ", Resident:" + adList.getResident() + ", listOfAddresses:");
		for(Address a: listOfAddresses) {
			System.out.print(a.getStreet() + " " + a.getCity() + " " + a.getState() + " " + a.getZip());
		}
		return "]";
	}

}
