package org.example;

import org.example.controller.ChatRoom;
import org.example.model.abstractClasses.Colleague;
import org.example.controller.interfaces.IMediator;

public class Chat {

    public static void main(String[] args) {

        IMediator chatRoom = new ChatRoom();

        Colleague pablo = chatRoom.createColleague("Pablo", "HUMANO");
        Colleague andre = chatRoom.createColleague("André", "HUMANO");
        Colleague romulo = chatRoom.createColleague("Rômulo", "HUMANO");
        Colleague vinicius = chatRoom.createColleague("Vinicius", "HUMANO");
        
        pablo.send("Como criar um chat ? Apple IBM");
        andre.send("Utilize o design pattern Mediator, é a solução para seu problema");
        vinicius.send("!getDay");
        romulo.send("!getTemp Sao Paulo");

        pablo.send("<img aaaaa");
        StringBuilder string = new StringBuilder();
        for(int i=0;i<282;i++){
            string.append("a");
        }
        pablo.send(string.toString());
    }
}