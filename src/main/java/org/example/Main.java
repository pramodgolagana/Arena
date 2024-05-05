package org.example;

import model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static void StartGamePlay(){
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

            System.out.println("There is a ");
        }

    }
    public static void main(String[] args) {

    }
}