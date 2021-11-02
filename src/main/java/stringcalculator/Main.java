package stringcalculator;

import stringcalculator.views.InputView;

public class Main {

    public static void main(String[] args) {

        try {
            String input = InputView.getWord();
            System.out.println(StringAddCalculator.splitAndSum(input));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
