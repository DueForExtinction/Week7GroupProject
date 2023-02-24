/**
 * 
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Address;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 23, 2023
 */
public class AddressItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7Project");
	
	public void insertAddress(Address ad) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ad);
		em.getTransaction().commit();
		em.close();
	}
}
