package org.cat.catalogue.services;

import org.cat.catalogue.dao.ProduitRepository;
import org.cat.catalogue.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProduitRestServices {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/listProduits")
    public List<Produit> getListProduits(){
        return produitRepository.findAll();
    }
    @GetMapping(value = "/Produit/{id}")
    public Produit getProduit(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }
}
