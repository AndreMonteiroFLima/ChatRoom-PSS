package org.example.controller.filtroChain;

import org.example.exception.FiltroException;

import java.util.ArrayList;

public class VigiaChat {

    private ArrayList<IFiltroMensagemStrategy> filtros;

    public VigiaChat() {
        this.filtros = new ArrayList<>();
        filtros.add(new LimiteCaracteresStrategy());
        filtros.add(new VerificaMarcaStrategy());
        filtros.add(new VerificaPDFStrategy());
        filtros.add(new VerificaHTMLStrategy());
    }

    public void analizaMensagem(Object msg) throws FiltroException {
        for (IFiltroMensagemStrategy strategy: filtros) {
                if(strategy.verifica(msg))
                    strategy.analiza(msg);
        }
    }
}
