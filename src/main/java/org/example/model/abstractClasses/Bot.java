package org.example.model.abstractClasses;

import org.example.controller.botChain.IBotChain;
import org.example.controller.interfaces.IMediator;
public abstract class Bot extends Colleague implements IBotChain {
    private String name;

    public Bot(IMediator chatIMediator, String participantName) {
        name = participantName;
        IMediator = chatIMediator;
    }

    public String getName() {
        return name;
    }


    @Override
    public void receive(String message, Colleague colleague) {
        System.out.printf("*** %s para %s: %s\n ****", colleague.getName(), this.getName(), message);
    }

    @Override
    public void receive(byte[] data, Colleague colleague){
        System.out.printf("*** %s para %s: %s\n ****", colleague.getName(), this.getName(), data);
    }
}