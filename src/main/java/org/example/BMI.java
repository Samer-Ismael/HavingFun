package org.example;

import java.util.Scanner;

public class BMI {

    public BMI (){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = input.nextDouble();
        System.out.print("Enter your height in centimeters: ");
        double height = input.nextDouble();
        height = height / 100.0;
        double bmi = weight / (height * height);
        System.out.println("Your BMI is: " + bmi);

        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal weight");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("BMI Category: Overweight");
        } else {
            System.out.println("BMI Category: Obesity");
        }
        input.close();
    }
}
