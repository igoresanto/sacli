/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import br.com.agenda.model.Contatos;
import java.util.List;

/**
 *
 * @author alisson
 */
public interface InterfaceContatos {
    public Contatos getContatos(Long id);
    public void salvar(Contatos contatos);
    public void remover(Contatos contatos);
    public void atualizar(Contatos contatos);
    public List<Contatos> lista();
}
