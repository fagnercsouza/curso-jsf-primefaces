package com.algaworks.erp.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//anotação indica que a instação gerada deve sobreviver durante o ciclo de vida da app
@ApplicationScoped
public class EntityManagerProduce {

    private EntityManagerFactory factory;
    public EntityManagerProduce(){
        this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
    }
    @Produces
    @RequestScoped
    public EntityManager createEntityManager(){
        return this.factory.createEntityManager();
    }
    public void closeEntityManager(@Disposes EntityManager manager){
        manager.close();
    }

}
