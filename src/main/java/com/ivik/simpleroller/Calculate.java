package com.ivik.simpleroller;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Eigenaar on 9-4-2016.
 */
public class Calculate {

    public StringBuilder calculate(String input) {
        Random diceRoller = new Random();
        int roll = 0;
        int sum = 0;
        int avrg = 0;
        int nat20 = 0;
        int nat1 = 0;
        String checkedInput = "";
        StringBuilder rejectedInput = new StringBuilder("Invalid input");
        StringBuilder output = new StringBuilder();

        boolean b = Pattern.matches("\\d*[d]\\d*", input);

        if (b == false){
            return rejectedInput;
        }else if (b == true){
            checkedInput = input;
        }

        String diceFaces[] = checkedInput.split("d");

        int dice = Integer.parseInt(diceFaces[0]);
        int faces = Integer.parseInt(diceFaces[1]);


        for (int i = 0; i < dice; i++) {
            roll = diceRoller.nextInt(faces) + 1;
            sum = sum + roll;

            if (roll == faces){
                output.append (roll + " NATURAL " + roll + "!\n");
                nat20++;
            }
            else if (roll == 1){
                output.append (roll + " NATURAL 1!\n");
                nat1++;
            }
            else {
                output.append (roll + "\n");

            }

        }
        avrg = sum / dice;
        output.append ("Average is   : " + avrg + "\n" + "Max values   : " + nat20 + "\n" + "Natural 1's  : " + nat1 + "\n");
        return output;
    }

}
