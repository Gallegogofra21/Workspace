package com.example.E02_EjercicioPractico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentoRepository repository;

    @PostConstruct
    public void init() {
        repository.saveAll(
                Arrays.asList(
                        new Monumento(39, "Italia", "Pisa", "43º 43' 23'' N", 20.396389, "Torre de Pisa", "La torre de Pisa o torre inclinada de Pisa es la torre campanario de la catedral de Pisa, situada en la plaza del Duomo de Pisa, en la ciudad del mismo nombre, municipio de la región italiana de la Toscana y capital de la provincia homónima de Italia.", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/The_Leaning_Tower_of_Pisa_SB.jpeg/250px-The_Leaning_Tower_of_Pisa_SB.jpeg"),
                        new Monumento(7, "Rusia", "Moscú", "55º 45' 00'' N", 353.543673, "Gran palacio de Kremlin", "El Gran Palacio del Kremlin (en ruso: Большой Кремлёвский дворец) es la residencia oficial del presidente de Rusia. Está ubicado en la parte sureste del Kremlin de Moscú, en la cima de la colina de Pinar.", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Grand_Kremlin_Palace%2C_Moscow.jpg/250px-Grand_Kremlin_Palace%2C_Moscow.jpg"),
                        new Monumento(34, "España", "Barcelona", "41º 24' 13'' N", 253.54364, "Templo Expiatorio de la Sagrada Familia", "El Templo Expiatorio de la Sagrada Familia conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona (España), diseñada por el arquitecto Antoni Gaudí. Iniciada en 1882, todavía está en construcción. ", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/SF_lago_2021.jpg/280px-SF_lago_2021.jpg")
                )
        );
    }
}
