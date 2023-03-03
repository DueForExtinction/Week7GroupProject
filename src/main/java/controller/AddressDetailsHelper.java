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
import javax.persistence.TypedQuery;

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
		List<AddressDetails> allDetails = em.createQuery("SELECT d FROM AddressDetails d").getResultList();
		return allDetails;
	}
	
	public AddressDetails searchForAddressDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AddressDetails found = em.find(AddressDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteAddressList(AddressDetails addressListToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AddressDetails> typedQuery = em.createQuery("select detail FROM AddressDetails detail where detail.id = :selectedId", AddressDetails.class);
		
		typedQuery.setParameter("selectedId", addressListToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		AddressDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
