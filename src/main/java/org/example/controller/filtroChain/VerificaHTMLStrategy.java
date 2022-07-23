package org.example.controller.filtroChain;

import org.example.exception.FiltroException;

import java.util.ArrayList;
import java.util.Collection;

public class VerificaHTMLStrategy implements IFiltroMensagemStrategy {

    private Collection<String> tags;

    public VerificaHTMLStrategy() {
        tags= new ArrayList<>();
        tags.add("<img");
        tags.add("<table");
        tags.add("<p");
        tags.add("<a href");
    }

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
        for (String tag: tags) {
            if(msg.toString().contains(tag)){
                throw new FiltroException("Mensagem removida por conter conteúdo não autorizado");
            }
        }
        return true;
    }
}
