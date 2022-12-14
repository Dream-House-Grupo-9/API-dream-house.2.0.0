package com.keys.plane.dreamhouse.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class ClienteId {
    @Id
    private Integer id;


    public ClienteId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
