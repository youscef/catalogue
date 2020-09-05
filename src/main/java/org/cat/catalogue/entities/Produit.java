package org.cat.catalogue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String designation;
    private double price;
    private int quantite;
}
