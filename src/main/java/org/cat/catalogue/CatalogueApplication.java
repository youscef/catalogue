package org.cat.catalogue;

import org.cat.catalogue.dao.ProduitRepository;
import org.cat.catalogue.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatalogueApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Ordinateur",5000,6));
		produitRepository.save(new Produit(null,"Telephone",6000,10));
		produitRepository.save(new Produit(null,"Voiture",90000,50));

		produitRepository.findAll().forEach(e->System.out.println(e.getDesignation()));

	}
}
