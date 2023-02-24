/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public List<Address> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> listAddresses = em.createQuery("SELECT i FROM Address i").getResultList();
		return listAddresses;
	}
	
	public void deleteAddress(Address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("SELECT adrs FROM Address adrs WHERE adrs.street = :selectedStreet and adrs.city = :selectedCity and adrs.state = :selectedState and adrs.zip = :selectZip", Address.class);
		typedQuery.setParameter("selectedStreet", toDelete.getStreet());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedState", toDelete.getState());
		typedQuery.setParameter("selectZip", toDelete.getZip());
		typedQuery.setMaxResults(1);
		
		Address result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Address searchForAddressById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateAddress(Address toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}


	


