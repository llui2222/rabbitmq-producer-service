package com.tpam.service.template.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String field;

    @Version
    private Integer version;

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }
}
