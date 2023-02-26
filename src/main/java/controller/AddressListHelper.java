package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AddressList;


public class AddressListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week7Project");
	
	public void insertAddressList(AddressList al) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(al);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AddressList> showAllAddressList(){
		EntityManager em = emfactory.createEntityManager();
		List<AddressList> allAddressLists = em.createQuery("SELECT al FROM AddressList al").getResultList();
		return allAddressLists;
	}
}
