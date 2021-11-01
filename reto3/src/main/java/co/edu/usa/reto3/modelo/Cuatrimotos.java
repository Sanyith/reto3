/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sanyi
 */
@Entity
@Table(name = "quadbike")
public class Cuatrimotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    @JsonIgnoreProperties("quadbikes")
    private Categoria category;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Mensajes> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="quadbike")
    @JsonIgnoreProperties("quadbike")
    private List<Reservas> reservations;

    public Integer getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Mensajes> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    public List<Reservas> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservas> reservations) {
        this.reservations = reservations;
    }

}
