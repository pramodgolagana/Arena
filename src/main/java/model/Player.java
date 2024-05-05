package model;


public class Player {
    private String  id;
    private int health;
    private int strength;
    private int attack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }



    public Player(String id, int health, int strength, int attack) {
        this.id = id;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    public Player(){

    }
}
