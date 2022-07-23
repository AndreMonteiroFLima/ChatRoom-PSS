package org.example.controller.interfaces;

import org.example.model.abstractClasses.Colleague;



public interface IChatRoomProxy{

    void send(Colleague colleague, String message);

    void send(Colleague colleague, byte[] data);

    Colleague createColleague(Colleague participant);
}
