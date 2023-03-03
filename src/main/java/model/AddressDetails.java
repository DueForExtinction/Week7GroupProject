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
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	public AddressDetails() {
		
	}
	
	public AddressDetails(int id, String detailsName, LocalDate accessDate, AddressList adList, List<Address> listOfAddresses) {
		this.id = id;
		this.detailsName = detailsName;
		this.accessDate = accessDate;
		this.adList = adList;
		this.listOfAddresses = listOfAddresses;
	}
	
	public AddressDetails(String detailsName, LocalDate accessDate, AddressList adList, List<Address> listOfAddresses) {
		this.detailsName = detailsName;
		this.accessDate = accessDate;
		this.adList = adList;
		this.listOfAddresses = listOfAddresses;
	}
	
	public AddressDetails(String detailsName, LocalDate accessDate, AddressList adList) {
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
	
	public List<Address> getListOfAddresses(){
		return listOfAddresses;
	}
	
	public void setListOfAddresses(List<Address> newList) {
		this.listOfAddresses = newList;
	}
	
	/**
	 * @return the adList
	 */
	public AddressList getAdList() {
		return adList;
	}

	/**
	 * @param adList the adList to set
	 */
	public void setAdList(AddressList adList) {
		this.adList = adList;
	}

	@Override
	public String toString() {
		return "AddressDetails [id=" + id + ", detailsName=" + detailsName + ", accessDate=" + accessDate + ", adList="
				+ adList + ", listOfAddresses=" + listOfAddresses + "]";
	}
	
	

}
