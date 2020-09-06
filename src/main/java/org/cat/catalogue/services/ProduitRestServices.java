package org.cat.catalogue.services;

import org.cat.catalogue.dao.ProduitRepository;
import org.cat.catalogue.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/produit/{id}")
    public Produit getProduit(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }
    @PutMapping(value = "/updateProduit/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id,@RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }
    @PostMapping(value = "/saveProduit")
    public Produit saveProduit(@RequestBody Produit p){
        return produitRepository.save(p);
    }
    @DeleteMapping(value = "deleteProduit/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
