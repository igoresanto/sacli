/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.controller;

import br.com.agenda.dao.ContatosDao;
import br.com.agenda.dao.InterfaceContatos;
import br.com.agenda.model.Contatos;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author alisson
 */

@ManagedBean
@SessionScoped
public class ContatosController {
    
    private Contatos contatos;
    private DataModel listaContatos;

    public Contatos getContatos() {
        if(this.contatos == null){
            this.contatos = new Contatos();
        }
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public DataModel getListaContatos() {
        List<Contatos> lista = new ContatosDao().lista();
        listaContatos = new ListDataModel(lista);
        return listaContatos;
    }

    public void prepararAdicionarContato(ActionEvent actionEvent){
        contatos = new Contatos();
    }
    
    public void prepararAlterarContato(ActionEvent actionEvent){
        contatos = (Contatos)(listaContatos.getRowData());
    }
    
    public void adicionar(ActionEvent actionEvent){
        InterfaceContatos dao = new ContatosDao();
        dao.salvar(contatos);
    }
    
    public void alterar(ActionEvent actionEvent){
        InterfaceContatos dao = new ContatosDao();
        dao.atualizar(contatos);
    }
    
    public String excluir(){
        Contatos contato = (Contatos)(listaContatos.getRowData());
        InterfaceContatos dao = new ContatosDao();
        dao.remover(contato);
        return "index";
    }
}
