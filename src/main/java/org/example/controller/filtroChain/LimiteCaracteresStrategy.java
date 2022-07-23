package org.example.controller.filtroChain;

import org.example.exception.FiltroException;

public class LimiteCaracteresStrategy implements IFiltroMensagemStrategy {
    @Override
    public boolean verifica(Object object) {
        if(object instanceof StringBuilder){
            return true;
        }
        return false;
    }

    @Override
    public boolean analiza(Object object) throws FiltroException {
        StringBuilder msg = (StringBuilder) object;
        if(msg.length()>280){
            throw new FiltroException("O limite de caracteres é de 280!");
        }
        return true;
    }
}
