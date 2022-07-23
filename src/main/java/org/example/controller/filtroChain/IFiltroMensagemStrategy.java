package org.example.controller.filtroChain;

import org.example.exception.FiltroException;

public interface IFiltroMensagemStrategy {

    boolean verifica(Object object);

    boolean analiza(Object object) throws FiltroException;

}
