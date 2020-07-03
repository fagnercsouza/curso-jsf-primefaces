package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class CamadaPersistencia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Declarando os repositórios
        RamoAtividades ramoAtividades = new RamoAtividades(em);
        Empresas empresas = new Empresas(em);

        //Buscando as informações do banco de dados
        List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
        List<Empresa> listaDeEmpresa = empresas.pesquisar("");
        System.out.println(listaDeEmpresa);

        //Criando uma empresa
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("José Farias");
        empresa.setCnpj("55.512.536/0001-20");
        empresa.setRazaoSocial("José Farias 55512536000120");
        empresa.setTipoEmpresa(TipoEmpresa.MEI);
        empresa.setDataFundacao(new Date());
        empresa.setRamoAtividade(listaDeRamoAtividades.get(0));

        //Salvando a empresa
        empresas.guardar(empresa);

        em.getTransaction().commit();
        //Verificando se a inserção funcionou
        List<Empresa> listaDeEmpresas = empresas.pesquisar("");
        System.out.println(listaDeEmpresas);

        em.close();
        emf.close();

    }
}
