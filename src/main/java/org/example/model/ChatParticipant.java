package org.example.model;

import org.example.model.abstractClasses.Colleague;

public class ChatParticipant extends Colleague {

    private String name;

    public ChatParticipant(org.example.controller.interfaces.IMediator chatIMediator, String participantName) {
        name = participantName;
        IMediator = chatIMediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        IMediator.send(this, message);
    }

    public void receive(String message, Colleague colleague) {
        System.out.printf("%s para %s: %s\n", colleague.getName(), this.getName(), message);
    }

    @Override
    public void receive(byte[] data, Colleague colleague) {
        System.out.printf("%s para %s: %s\n", colleague.getName(), this.getName(), data);
    }
}