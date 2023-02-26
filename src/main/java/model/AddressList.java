package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddressList")
public class AddressList {
	@Id
	@GeneratedValue
	private int id;
	private String resident;
	
	public AddressList(){
		
	}
	
	public AddressList(int id, String resident) {
		this.id = id;
		this.resident = resident;
	}
	
	public AddressList(String resident) {
		this.resident = resident;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	@Override
	public String toString() {
		return "AddressList [id=" + id + ", resident=" + resident + "]";
	}
	
	
}
