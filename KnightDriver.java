/**
 * Villafranca, Rikki Lee
 * COP-3252
 * Assignment 4
 * 02/02/23
 */


import java.util.Random;
import java.util.Scanner;
import java.lang.*;

public class KnightDriver {


    public static void main(String[] args) {

        //Variables
        String name, Oname, choice, quit;
        int weapon, Oppweapon;

        Scanner input = new Scanner(System.in);

        //Welcome and name input
       do { System.out.println("Welcome to knight fight!");
        System.out.print("Enter the name of your knight: ");
        name = input.next();

        //Weapon Choice and validation
        wChoice();
        do {
            System.out.print("Your choice my liege? : ");
            weapon = input.nextInt();
        }
        while (weapon < 1 || weapon > 4);

        //Sets a knight called userKnight using user inputs with random armor and HP
        Knight UserKnight = new Knight(name, convertWeapon(weapon), getRandomArmor(), getRandomHP());

        //Asks user eiher to auto-generate or create opponent
        System.out.print("Would you like to autogenerate your opponent? (Y|N) : ");
        choice = input.next();

        //Creates the opponent called OpponentKnight from knight Class
        Knight OpponentKnight = null;
        if (choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes")) {
            System.out.println("Auto-generating opponent...");
            OpponentKnight = new Knight(getRandomName(), getRandomWeapon(), getRandomArmor(), getRandomHP());
        } else if (choice.equals("n") || choice.equals("N") || choice.equals("No") || choice.equals("no")) {
            System.out.print("Enter the name of your opponent: ");
            Oname = input.next();
            wChoice();
            do {
                System.out.print("Your choice my liege? : ");
                Oppweapon = input.nextInt();
            }
            while (Oppweapon < 1 || Oppweapon > 4);
            OpponentKnight = new Knight(Oname, convertWeapon(Oppweapon), getRandomArmor(), getRandomHP());
        }

        //Displays the attributes of both knights
        UserKnight.displayAttributes();
        OpponentKnight.displayAttributes();

        OpponentKnight.fight(UserKnight);

        //Quit game
        System.out.print("Would you like to play again? (Yes|No) : ");
        quit = input.next();
    }
       while (!quit.equals("n") || !quit.equals("N") || !quit.equals("No") || !quit.equals("no"));


    }

// *******************************************************
// *        KnightDriver class choice menu.              *
// *******************************************************
    public static void wChoice() {

        System.out.println("""
                Choose the weapon (1-4)!
                1) Long Sword
                2) Battle Axe
                3) Spear
                4) Warhammer\s""");

    }

// *******************************************************
// *        KnightDriver class armor convertor.          *
// *******************************************************
    public static String convertArmor(int a) {
        String at = null;
        switch (a) {
            case 1: at = "Leather Armor";
                break;
            case 2: at = "Metal Armor";
                break;
        }
        return at;
    }

// *******************************************************
// *       KnightDriver class weapon convertor.          *
// *******************************************************
    public static String convertWeapon(int w){
        String weapon = null;
        switch (w) {
            case 1: weapon = "Long Sword";
                break;
            case 2: weapon = "Battle Axe";
                break;
            case 3: weapon = "Spear";
                break;
            case 4:  weapon = "Warhammer";
                break;
            default:  System.out.print("Error. Invalid Input. ");
        }

        return weapon;
    }

// *******************************************************
// *    KnightDriver class returns a random name from    *
// *    a string array.                                  *
// *******************************************************
    public static String getRandomName() {
        Random rand = new Random();
        String[] s = {"David King", "John Graham", "Ezekiel Griffith", "Robert Carson", "Samuel Adams", "Nathaniel Berrett",
                "Benjamin Davis", "Wyatt Levine", "Jaxson Nora", "Thomas Bardot", "Emiliano Jackson", "Connor Kade",
                "Giovanni Cromwel", "Ian Thatcher", "Guts Claymore", "Harry Potter"};

        int index = rand.nextInt(s.length);
        return s[index];
    }

// *******************************************************
// *   KnightDriver class returns a random weapon from   *
// *    using weapon convertor function.                 *
// *******************************************************
    public static String getRandomWeapon() {
        Random rand = new Random();
        int randWeapon = rand.nextInt(1, 5);
        return convertWeapon(randWeapon);
    }

// *******************************************************
// *   KnightDriver class returns a random armor from    *
// *    using armor convertor function.                  *
// *******************************************************
    public static String getRandomArmor() {
        Random rand = new Random();
        int randArmor = rand.nextInt(1,3);
        return convertArmor(randArmor);
    }


// *******************************************************
// * KnightDriver class returns a random HP from 50-100  *
// *******************************************************
    public static int getRandomHP() {
        Random rand = new Random();
        return rand.nextInt(50,101);
    }

}