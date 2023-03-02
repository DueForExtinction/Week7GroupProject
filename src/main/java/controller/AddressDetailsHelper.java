/**
 * @author Chance - cbenna
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AddressDetails;

/**
 * @author Chance
 *
 */
public class AddressDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7Project");
	
	public void insertNewAddressDetails(AddressDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AddressDetails> getDetails(){
		EntityManager em = emfactory.createEntityManager();
		List<AddressDetails> allDetails = em.createQuery("SELECT d from AddressDetails d").getResultList();
		return allDetails;
	}

}
