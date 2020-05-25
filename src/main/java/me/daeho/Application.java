package me.daeho;

import me.daeho.calculator.StringAddCalculator;
import me.daeho.view.InputView;
import me.daeho.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String text = InputView.create().input();
        int result = StringAddCalculator.splitAndSum(text);
        ResultView.showResult(result);
    }
}
