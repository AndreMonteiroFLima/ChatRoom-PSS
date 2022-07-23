package org.example.model;

import org.example.model.abstractClasses.Bot;
import org.example.model.abstractClasses.Colleague;
import org.example.controller.interfaces.IMediator;

import java.util.Calendar;

public class BotDataEHora extends Bot {


    public BotDataEHora(IMediator chatIMediator, String participantName) {
        super(chatIMediator,participantName);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public void send(String message) {
        Calendar h = Calendar.getInstance();
        int dia = h.get(Calendar.DAY_OF_MONTH);
        int mes = h.get(Calendar.MONTH);
        int horas = h.get(Calendar.HOUR);
        int minutos = h.get(Calendar.MINUTE);
        IMediator.send(this,"Hoje é: "+dia+"/"+mes+" e são: "+horas+":"+minutos);
    }

    @Override
    public void receive(String message, Colleague colleague) {
       super.receive(message,colleague);
    }

    @Override
    public void receive(byte[] data, Colleague colleague) {

    }

    @Override
    public boolean verifica(String message) {
        if(message.startsWith("!getDay")){
            return true;
        }
        return false;
    }
}