package service;

import model.Player;

import java.util.ArrayList;

public class GamePlay extends Player {
    public int rolling(){
        int randomNumber = (int)(Math.random() * 6) + 1;
        return randomNumber;

    }
    public int attack(Player p){
        int dice=rolling();
        return dice*p.getAttack();
    }
    public int defend(Player p){
        int dice=rolling();
        return dice*p.getStrength();
    }
    public Player getAttacker(Player p1 , Player p2){
        return (p1.getHealth()> p2.getHealth()) ? p1 : p2;
    }
    public Player getDefender(Player p1 , Player p2){
        return p1.getHealth()> p2.getHealth() ? p2 : p1;
    }
    public void desideHealth(int result, Player defender){
        if(result>0){
            defender.setHealth(defender.getHealth()-result);
        }
    }
    public static ArrayList<Player> swapPlayers(ArrayList<Player> Battlers){
        Player temp = Battlers.get(0);
        Battlers.set(0,Battlers.get(1));
        Battlers.set(1,temp);
        return Battlers;
    }

}
