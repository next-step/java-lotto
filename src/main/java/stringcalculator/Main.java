package stringcalculator;

import stringcalculator.views.InputView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String input = inputView.getWord();

        int result = StringAddCalculator.splitAndSum(input);
        System.out.println(result);
    }

}
