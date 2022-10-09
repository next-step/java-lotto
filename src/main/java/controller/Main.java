package controller;

import java.util.ArrayList;
import java.util.List;

import service.CalculateCurrentElements;
import domain.Calculator;
import domain.Divide;
import domain.FindCalculateStrategy;
import domain.Minus;
import domain.Multiply;
import domain.Plus;
import domain.InputValues;
import service.Calculate;
import view.InputValidation;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        InputValidation inputValidation = new InputValidation();
        InputValues inputValues = inputView.inputInfo(inputValidation);

        List<Calculator> calculatorList = new ArrayList<>();

        Plus plus = new Plus();
        Divide divide = new Divide();
        Minus minus = new Minus();
        Multiply multiply = new Multiply();

        calculatorList.add(plus);
        calculatorList.add(divide);
        calculatorList.add(minus);
        calculatorList.add(multiply);

        FindCalculateStrategy findCalculateStrategy = new FindCalculateStrategy(calculatorList);

        Calculate calculate = new Calculate();
        CalculateCurrentElements calTmpArr = new CalculateCurrentElements(findCalculateStrategy);

        String result = calculate.calculateInputValue(inputValues, calTmpArr);

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}
