package calculator;

import java.util.Scanner;

public class StringCalculatorApp {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);){
            StringCalculator.calculate(sc.next());
        }catch (IllegalArgumentException e){
            System.out.println("invalid input");
            throw e;
        }
    }
}
