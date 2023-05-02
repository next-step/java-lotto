import stringCalculator.domain.StringCalculation;
import stringCalculator.domain.Numbers;
import stringCalculator.domain.Operators;
import stringCalculator.view.InputView;

public class Main {
    public static void main(String[] args) {

        // 입력 및 계산
        String[] stringArray = InputView.inputOperationsAndNumber();
        Numbers numbers = new Numbers();
        Operators operator = new Operators();

        for (int i = 1; i <= stringArray.length; i++) {
            if(isNumbersPosition(i)) {
                numbers.addNumber(stringArray[i-1]);
            }
            if(!isNumbersPosition(i)) {
                operator.addOperators(stringArray[i-1]);
            }
        }

        StringCalculation calculation = new StringCalculation();
        calculation.calculate(numbers, operator);

        System.out.println(calculation.toString());

    }

    private static boolean isNumbersPosition(int index) {
        return index % 2 != 0;
    }
}
