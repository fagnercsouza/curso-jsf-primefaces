package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SchemaGeneration {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> list = em.createQuery("from Empresa", Empresa.class).getResultList();

        System.out.println(list);
        em.close();
        emf.close();
    }
}
