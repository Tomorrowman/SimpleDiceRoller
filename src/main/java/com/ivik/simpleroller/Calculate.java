package com.ivik.simpleroller;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Tomorrowman on 9-4-2016.
 */
public class Calculate {

    public StringBuilder calculate(String input) {
        Random diceRoller = new Random();
        int roll = 0;
        int rollMod = 0;
        int PosMod = 0;
        int NegMod = 0;
        int sum = 0;
        int avrg = 0;
        int nat20 = 0;
        int nat1 = 0;
        String checkedInput = "";
        StringBuilder rejectedInput = new StringBuilder("Invalid input");
        StringBuilder output = new StringBuilder();

        boolean b = Pattern.matches("\\d*[d]\\d*|\\d*[d]\\d*[+-]\\d*", input);

        if (!b){
            return rejectedInput;
        }else if (b){
            checkedInput = input;
        }

        String diceFacesMods[] = checkedInput.split("[d]|[+-]");

        int dice = Integer.parseInt(diceFacesMods[0]);
        int faces = Integer.parseInt(diceFacesMods[1]);
        if (Pattern.matches("\\d*[d]\\d*[+]\\d*", checkedInput)) {
            PosMod = Integer.parseInt(diceFacesMods[2]);
        }
        else if (Pattern.matches("\\d*[d]\\d*[-]\\d*", checkedInput)){
            NegMod = Integer.parseInt(diceFacesMods[2]);
        }


        for (int i = 0; i < dice; i++) {
            roll = diceRoller.nextInt(faces) + 1;
            rollMod = roll + PosMod - NegMod;
            sum = sum + roll;

            if (roll == faces){
                output.append (rollMod + " NATURAL " + roll + "!\n");
                nat20++;
            }
            else if (roll == 1){
                output.append (rollMod + " NATURAL 1!\n");
                nat1++;
            }
            else {
                output.append (rollMod + "\n");

            }

        }
        avrg = sum / dice;
        output.append ("Average is   : " + avrg + "\n" + "Max values   : " + nat20 + "\n" + "Natural 1's  : " + nat1 + "\n");
        return output;
    }

}
