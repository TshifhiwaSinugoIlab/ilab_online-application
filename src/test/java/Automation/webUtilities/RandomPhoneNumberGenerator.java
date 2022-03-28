package Automation.webUtilities;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RandomPhoneNumberGenerator {

    public static String RandomGenerator(WebDriver driver){

        Random generator = new Random();

        int num1, num2, num3; //first three numbers
        int set2, set3;

        num1 = generator.nextInt(1);
        num2 = generator.nextInt(3) + 6;
        num3 = generator.nextInt(8);

        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;


        String PhoneNumbers = ( "(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3 );


        return PhoneNumbers;
    }
}
