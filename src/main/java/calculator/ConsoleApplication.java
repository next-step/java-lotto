package calculator;

import calculator.domain.Calculator;
import calculator.domain.CalculatorDTO;
import calculator.view.CalculatorView;

import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        doCalculator();

    }

    private static void doCalculator() {
        try {
            //input 값 가져오기
            String value = CalculatorView.getInputValue();

            //input 값 유효성 체크 및 split
            List<String> splitValues = CalculatorDTO.splitInputValue(value, CalculatorDTO.checkCustomSeparator(value));

            //계산
            int result = Calculator.sum(splitValues);

            //print result
            System.out.println(result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

