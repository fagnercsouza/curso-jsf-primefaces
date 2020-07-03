package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import jdk.internal.dynalink.linker.LinkerServices;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class Empresas implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public Empresas(){

    }
    public Empresas(EntityManager manager){
        this.manager = manager;
    }
    public Empresa porId(Long id){
        return manager.find(Empresa.class, id);
    }
    public List<Empresa> pesquisar(String nome){
        Query query = manager.
                createQuery("from Empresa where nomeFantasia like :nomeFantasia");
        query.setParameter("nomeFantasia", nome +"%");

        return query.getResultList();
    }
    public Empresa guardar(Empresa empresa){

        return manager.merge(empresa);
    }
    public void remover(Empresa empresa){
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }

}
