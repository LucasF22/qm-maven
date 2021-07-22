package br.com.qm.carro.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.qm.carro.pojo.Carro;

public class CarroDAOHibernate {
	private EntityManager em;
	
	public CarroDAOHibernate() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		this.em = factory.createEntityManager();
	}
	
	public boolean adicionaCarro(Carro carro) {
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		
		return true;
	}
	
	public boolean removeCarro(String placa) {
		Carro carro = em.find(Carro.class, placa);
		if(carro == null) {
			return false;
		}
		
		em.getTransaction().begin();
		em.remove(carro);
		em.getTransaction().commit();
		
		return true;
	}
	
	public Carro consultaCarro(String placa) {
		return em.find(Carro.class, placa);
	}
	
	public boolean alteraCarro(Carro carro) {
		Carro carroBD = em.find(Carro.class, carro.getPlaca());
		carroBD.setCor(carro.getCor());
		carroBD.setMarca(carro.getMarca());
		carroBD.setModelo(carro.getModelo());
		carroBD.setVelMax(carro.getVelMax());
		
		em.getTransaction().begin();
		em.merge(carroBD);
		em.getTransaction();
		
		return true;
	}
	
	public List<Carro> listarCarro(){
		Query query = em.createQuery("select c from Carro as c");
		return query.getResultList();
	}
	
	public List<Carro> listarCarrosPorFabricante(String marca){
		Query query = em.createQuery("Select c from Carro as c where c.marca = :marca");
		query.setParameter("marca", marca);
		return query.getResultList();
	}
}
