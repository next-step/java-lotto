package caculator.controller;

import caculator.domain.Calculator;
import caculator.domain.Formula;
import caculator.view.UserInput;

import java.util.List;

public class Main {

    public void run() {
        System.out.println("연산을 입력하세요.");
        UserInput input = new UserInput();
        List<String> formula = Formula.strToList(input.inputFormula());

        int result = Calculator.calculate(formula);
        System.out.println("결과 : " + result);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
