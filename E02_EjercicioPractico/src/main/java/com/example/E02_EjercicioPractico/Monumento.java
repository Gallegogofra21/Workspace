package com.example.E02_EjercicioPractico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private int codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private String latitud;
    private double longitud;
    private String nombreMonumento;

    @Lob
    //@Column(length = 1000)
    //@Column(columnDefinition = "TEXT")
    private String descripcion;
    private String urlFoto;

    public Monumento(int codigoPais, String nombrePais, String nombreCiudad, String latitud, double longitud, String nombreMonumento, String descripcion, String urlFoto) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreMonumento = nombreMonumento;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
}
