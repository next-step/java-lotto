package calculator.view;


import java.util.Scanner;

public class CalculatorInputView {

    Scanner scanner = new Scanner(System.in);


    public String input() {
        return scanner.nextLine();
    }

    public String inputNumberSentence() {
        String numberSentence = input();

        return numberSentence;
    }
}
