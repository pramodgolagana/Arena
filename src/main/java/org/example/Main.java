package org.example;

import model.Player;
import service.GamePlay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static service.GamePlay.swapPlayers;

public class Main {




    static void startGamePlay(){
        Player p1 = new Player();
        Player p2 = new Player();


        String filePath = "src/main/resources/playersInfo";

        try {

            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String playerInfo=line;
                String[] playerDetails= playerInfo.split(",");

                p1 = new Player(playerDetails[0],Integer.parseInt(playerDetails[1]),Integer.parseInt(playerDetails[2]),Integer.parseInt(playerDetails[3]));
                p2 = new Player(playerDetails[4],Integer.parseInt(playerDetails[5]),Integer.parseInt(playerDetails[6]),Integer.parseInt(playerDetails[7]));

            }

            bufferedReader.close();
        } catch (IOException e) {

            System.out.println("Given file path is not valied, Please enter a valied file path");
        }
        GamePlay gamePlay= new GamePlay();
        ArrayList<Player> Battlers = new ArrayList<>();
        Player attacker = gamePlay.getAttacker(p1,p2);
        Player defender = gamePlay.getDefender(p1,p2);
        Battlers.add(attacker);
        Battlers.add(defender);


        while(attacker.getHealth()>0 && defender.getHealth()>0){

            int attack = gamePlay.attack(Battlers.get(0));
            int deffend = gamePlay.defend(Battlers.get(1));
            gamePlay.desideHealth(attack-deffend,Battlers.get(1));
            swapPlayers(Battlers);

        }
        if(attacker.getHealth()>0)
            System.out.println("Player "+ attacker.getId() +" won the match, Congratulations!");
        else
            System.out.println("Player "+ defender.getId() +" won the match, Congratulations!");
    }

    public static void main(String[] args) {
        startGamePlay();
    }
}