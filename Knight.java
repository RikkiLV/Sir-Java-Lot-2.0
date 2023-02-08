/**
 * Villafranca, Rikki Lee
 * COP-3252
 * Assignment 4
 * 02/02/23
 */


import java.util.Random;

public class Knight {

// *******************************************************
// *              Knight class variables.                *
// *******************************************************
    private String username, userweapon, armortype;
            int hp;


// *******************************************************
// *             Knight class constructors.              *
// *******************************************************

    public Knight(String n, String w) {

        this.username = n;
        this.userweapon = w;
        this.armortype = " ";
        this.hp = 100;


    }
    public Knight(String n, String w, String a, int h) {

        this.username = n;
        this.userweapon = w;
        this.armortype = a;
        this.hp = h;

    }

// *******************************************************
// *         Knight class set/get functions.             *
// *******************************************************


    public void setName(String n){
        this.username = n;
    }

    public String getName() {
        return username;
    }
    public void setWeapon(String w){
        this.userweapon = w;
    }

    public String getWeapon() {
        return userweapon;
    }

    public void setArmortype(String a){
        this.armortype = a;
    }

    public String getArmortype() {
        return armortype;
    }

    public void setHP(int h){
        this.hp = h;
    }

    public int getHP() {
        return hp;
    }

// *******************************************************
// *          Knight class toget() function.             *
// *******************************************************

    public void displayAttributes() {
        System.out.println("Name: " + getName() +
                "\nWeapon: " + getWeapon() +
                "\nArmor type: " + getArmortype() +
                "\nHP: " + getHP());


    }


// *******************************************************
// *            Knight class fight fuction.              *
// *******************************************************


    public void fight(Knight user) {
        Random rand = new Random();

        //Variables
        int damage = 0;
        int armorEffect = 0;

        //Switch function that will modify damage depending on armortype and weapon type.
        //Armor effect was random and was decided by Rikki.
        switch (getWeapon()) {
            case "Long Sword":
                if (user.armortype.equals("Leather Armor")) {
                    armorEffect += 10;
                }
                else {
                    armorEffect += 4;
                }
                break;
            case "Battle Axe":
                if (user.armortype.equals("Leather Armor")) {
                    armorEffect += 20;
                }
                else {
                    armorEffect += 5;
                }
                break;
            case "Spear":
                if (user.armortype.equals("Leather Armor")) {
                    armorEffect += 8;
                }
                else {
                    armorEffect += 3;
                }
                break;
            case "Warhammer":
                if (user.armortype.equals("Leather Armor")) {
                    armorEffect += 15;
                }
                else {
                    armorEffect += 6;
                }
                break;
        }

        //Damage increases depending on the previous switch function
        damage += armorEffect;

        //Counter for the battle rounds and a random turn variable
        int counter = 0;
        int turn = rand.nextInt(1,3);

        //Do-loop will play while either user or opponent still have HP > 0
        //The increased damage will affect the hp of whoever's turn it is
        do  {
            if (turn == 1) {
                System.out.println("Round: " + counter++);
                this.hp -= damage;
                System.out.println(this.getName() + " has " + this.hp + " HP!");
                if (this.hp < 0) { this.hp = 0; }
                turn = 2;
            }
            else if (turn == 2) {
                System.out.println("Round: " + counter++);
                user.hp -= damage;
                System.out.println(user.getName() + " has " + user.hp + " HP!");
                if (user.hp < 0) { user.hp = 0; }
                turn = 1;

            }
        } while (user.hp > 0 && this.hp > 0);

        //If statement will display whether user won or lost
        if (user.hp > 0) {
            System.out.print("You won!");
        } else if (this.hp > 0) {
            System.out.print("You Lost !");
        }
    }


}
