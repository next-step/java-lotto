package caculator;

import java.util.List;

public class Main {

    public void run() {
        System.out.println("연산을 입력하세요.");
        UserInput input = new UserInput();
        List<String> formula = input.inputFormula();

        Calculator calculator = new Calculator();
        int result = calculator.calculate(formula);
        System.out.println("결과 : " + result);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
