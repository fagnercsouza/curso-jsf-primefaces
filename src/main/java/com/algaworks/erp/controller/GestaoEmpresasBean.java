package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * TIPO DE ESCOPO
 * RequestScoped = é criado a cada requisição
 * ViweScoped = é criado quando carrega a página (GET)
 * SessionScoped = é criado a cada inicio de sessão
 * ApplicationScoped = é criado uma única instância
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
        return empresa;
    }
    public TipoEmpresa[] getTiposEmpresa(){
        return TipoEmpresa.values();
    }
    public void salvar(){
        System.out.println("Razão social: "+empresa.getRazaoSocial()
                + " - "+empresa.getNomeFantasia()
                +" - "+ empresa.getTipoEmpresa()
                + " - " +empresa.getCnpj());
    }


    //    private static Integer NUMERO = 0;
//    public GestaoEmpresasBean(){
//        NUMERO++;
//    }
//    public Integer getNumero(){
//        return NUMERO;
//    }
}
