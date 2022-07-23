package org.example.controller.botChain;

import java.util.ArrayList;
import java.util.Collection;

public class ControlaBot {
    private Collection<IBotChain> botChains = new ArrayList<>();

    public ControlaBot() {

    }

    public void addBotToChain(IBotChain newBot){
        botChains.add(newBot);
    }

    public void verificaBot(String message){
        for (IBotChain bot: botChains) {
            if(bot.verifica(message)){
                bot.send(message);
            }
        }
    }


}
