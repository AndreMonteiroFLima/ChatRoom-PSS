package org.example.controller;

import org.example.controller.botChain.ControlaBot;
import org.example.controller.interfaces.IChatRoomProxy;
import org.example.model.abstractClasses.Bot;
import org.example.model.abstractClasses.Colleague;

import java.util.ArrayList;

class ChatRoomReal implements IChatRoomProxy {

    private ArrayList<Colleague> participants;
    private ControlaBot controlaBot;
    public ChatRoomReal(ControlaBot bot) {
        participants = new ArrayList<Colleague>();
        controlaBot= bot;
    }

    @Override
    public void send(Colleague colleague, String message) {
        for (int i = 0, t = participants.size(); i < t; ++i) {
            Colleague participant = participants.get(i);
            if (!participant.equals(colleague) && !(participant instanceof Bot)) {
                participant.receive(message, colleague);
            }
            if ((participant instanceof Bot)){
                controlaBot.verificaBot(message);
            }
        }
    }

    @Override
    public void send(Colleague colleague, byte[] data) {
        for (int i = 0, t = participants.size(); i < t; ++i) {
            Colleague participant = participants.get(i);
            if (!participant.equals(colleague) && !(participant instanceof Bot)) {
                participant.receive(data, colleague);
            }
        }
    }


    @Override
    public Colleague createColleague(Colleague participant) {
        participants.add(participant);

        return participant;
    }
}