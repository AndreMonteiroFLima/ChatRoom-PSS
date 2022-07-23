package org.example.controller;

import org.example.controller.botChain.ControlaBot;
import org.example.controller.filtroChain.VigiaChat;
import org.example.exception.FiltroException;
import org.example.model.BotDataEHora;
import org.example.model.BotTemperaturaAtual;
import org.example.model.ChatParticipant;
import org.example.model.abstractClasses.Colleague;
import org.example.controller.interfaces.IMediator;

public class ChatRoom implements IMediator {

    private final ControlaBot controlaBot;
    private ChatRoomReal chatRoomReal;
    private VigiaChat vigia= new VigiaChat();

    public ChatRoom() {
        controlaBot = new ControlaBot();
        controlaBot.addBotToChain(new BotDataEHora(this,"Robô 1"));
        controlaBot.addBotToChain(new BotTemperaturaAtual(this,"Robô 2"));

        chatRoomReal = new ChatRoomReal(controlaBot);
    }

    @Override
    public void send(Colleague colleague, String message) {
        StringBuilder analizar=new StringBuilder(message);

        try {
            vigia.analizaMensagem(analizar);
            message=analizar.toString();
            chatRoomReal.send(colleague,message);
        } catch (FiltroException e) {
            System.out.println("Sua mensagem não pode ser enviada:"+e.getMessage());
        }
    }

    @Override
    public void send(Colleague colleague, byte[] data) {
        try {
            vigia.analizaMensagem(data);
            chatRoomReal.send(colleague,data);
        } catch (FiltroException e) {
            System.out.println("Sua mensagem não pode ser enviada:"+e.getMessage());
        }
    }

    @Override
    public Colleague createColleague(String name, String type) {
        Colleague participant = null;
        if (type.equals("HUMANO")) {
            participant = new ChatParticipant(this, name);
        }
        return chatRoomReal.createColleague(participant);
    }

    @Override
    public Colleague createColleague(Colleague participant) {
        if(participant!=null)
            return chatRoomReal.createColleague(participant);
        return null;
    }
}