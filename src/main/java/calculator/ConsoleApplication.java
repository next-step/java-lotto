package calculator;

import calculator.domain.CalculatorCore;
import calculator.domain.CalculatorUtils;
import calculator.view.CalculatorInputView;

import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        doCalculator();

    }

    private static void doCalculator() {
        try {
            //input 값 가져오기
            String value = CalculatorInputView.getInputValue();

            //input 값 유효성 체크 및 split
            List<String> splitValues = CalculatorUtils.splitInputValue(value, CalculatorUtils.checkCustomSeparator(value));

            //계산
            int result = CalculatorCore.sum(splitValues);

            //print result
            System.out.println(result);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

