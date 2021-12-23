import Messages.ActionMenu;
import Messages.NameEntering;

import java.util.Random;
import java.util.Scanner;

public class Robot {
    public static String keys = "QWEASDZXCP";
    String battleKeys = "QWEASDZXC";
    private String damageKeys = "";
    String robotName;
    int health = 100;

    public Robot(String name) {
        this.robotName = name;
        for (int i = 0; i < 5; i++) {
            damageKeys = damageKeys + getRandomKey();
        }

    }


    char getRandomKey() {
        int randIndx = new Random().nextInt(battleKeys.length());
        char randChar = battleKeys.charAt(randIndx);
        battleKeys = battleKeys.replace(String.valueOf(randChar), "");
        return randChar;
    }
    //  metod dlya udara robota
    public char enteredKey() {
        try {
            Scanner text = new Scanner(System.in);
            return text.nextLine().charAt(0);
        }catch (Exception e){
            System.out.println("Please enter value");
            return enteredKey();
        }
    }
    // metod dlya proverki dopustimosti vvedennoy bukvi
    public boolean charCheck(char checkKey) {
        for (int i = 0; i < keys.length(); i++) {
            if (String.valueOf(checkKey).equalsIgnoreCase(String.valueOf(keys.charAt(i)))) {
                return true;
            }

        }
        return false;
    }
    // metod proverki na popadanie
    boolean hitRobot(char gotKey, String name) {
        while (!charCheck(gotKey)) {
            System.out.println(name + " Please enter correct value ");
            gotKey = enteredKey();
        }
        for (int i = 0; i < damageKeys.length(); i++) {
            if (String.valueOf(gotKey).equalsIgnoreCase(String.valueOf(damageKeys.charAt(i)))) {
                battleKeys = battleKeys + damageKeys.charAt(i);
                damageKeys = damageKeys.replace(String.valueOf(damageKeys.charAt(i)), "");
                return true;
            } else if (String.valueOf(gotKey).equalsIgnoreCase(String.valueOf(battleKeys.charAt(i)))) {
                return false;
            } else if (String.valueOf(gotKey).equalsIgnoreCase("p")) {
                System.out.println("You are self destroyed");
                return false;
            }
        }
        return false;
    }
}
