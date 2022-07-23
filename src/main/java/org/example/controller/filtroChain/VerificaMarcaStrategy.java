package org.example.controller.filtroChain;

import org.example.exception.FiltroException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class VerificaMarcaStrategy implements IFiltroMensagemStrategy {

    private Collection<String> marcas = new ArrayList<>();

    public VerificaMarcaStrategy() {
        this.marcas.add("Apple");
        this.marcas.add("Microsoft");
        this.marcas.add("IBM");
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
        try {
            for (String marca : marcas) {
                if (msg.toString().contains(marca)) {
                    char[] buf = new char[marca.length()];
                    Arrays.fill(buf, '*');
                    msg = msg.replace(msg.indexOf(marca), msg.indexOf(marca) + marca.length(), new String(buf));
                }
            }
        }catch (Exception e){
            throw new FiltroException("Algo deu errado ao verificar se existiam marcas na sua mensagem! Tente novamente");
        }
        return true;
    }
}
