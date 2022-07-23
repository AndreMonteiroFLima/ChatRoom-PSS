package org.example.model.abstractClasses;

public abstract class Colleague {

    protected org.example.controller.interfaces.IMediator IMediator;

    public abstract String getName();

    public abstract void send(String message);

    public abstract void receive(String message, Colleague colleague);

    public abstract void receive(byte[] data,Colleague colleague);
}