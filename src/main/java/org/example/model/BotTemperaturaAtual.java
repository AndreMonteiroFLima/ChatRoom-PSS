package org.example.model;

import com.google.gson.Gson;
import org.example.model.abstractClasses.Bot;
import org.example.model.abstractClasses.Colleague;
import org.example.controller.interfaces.IMediator;
import org.example.util.GsonPrettyGetter;
import org.example.util.HGBrasilUtil;

public class BotTemperaturaAtual extends Bot {

    Previsao previsao = new Previsao();

    public BotTemperaturaAtual(IMediator chatIMediator, String participantName) {
        super(chatIMediator,participantName);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public boolean verifica(String message) {
        if(message.startsWith("!getTemp")){
            return true;
        }
        return false;
    }

    @Override
    public void send(String message) {
        String parts[] = message.split(" ",2);
        int temp = getPrevisao(parts[1]);
        IMediator.send(this,"A Temperatura Atual para "+parts[1]+" é de: "+temp+"°");
    }

    @Override
    public void receive(String message, Colleague colleague) {
        super.receive(message,colleague);
    }

    @Override
    public void receive(byte[] data, Colleague colleague) {
        super.receive(data,colleague);
    }

    private int getPrevisao(String logradouro){
        Gson gson = GsonPrettyGetter.getGson();
        String previsaoJson = HGBrasilUtil.previsaoUtilHg(logradouro);
        previsao = (Previsao) gson.fromJson(previsaoJson, Previsao.class);
        return previsao.getTemp();
    }



}