package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringHiding {

    public StringHiding(String name){

        Scanner scan = new Scanner(System.in);

        List<Character> makeLines = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            makeLines.add('_');
        }
        System.out.println("Enter a letter or guess the full name of " + name.length() + " letters: ");

        char[] nameLetters = name.toLowerCase().toCharArray();

        while (true) {

            String input = scan.next();
            if (input.equalsIgnoreCase("exit")) System.exit(0);
            if (input.equalsIgnoreCase(name)) {
                System.out.println("You got it: " + name);
                break;
            }
            boolean tellItsWrong = true;

            char inputChar = input.charAt(0);
            for (int i = 0; i < nameLetters.length; i++) {
                if (inputChar == nameLetters[i]) {
                    makeLines.set(i, inputChar);
                    tellItsWrong = false;
                }
            }
            if (tellItsWrong) System.out.println("Wrong! Try again");

            StringBuilder toPrint = new StringBuilder();

            for (char letterToPrint : makeLines) {
                toPrint.append(letterToPrint);
            }
            if (toPrint.toString().equalsIgnoreCase(name)) {
                System.out.println("You got it: " + name);
                break;
            }
            for (int i = 0; i < toPrint.length(); i++) {
                System.out.print(toPrint.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
