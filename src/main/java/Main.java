import stringCalculator.domain.StringCalculation;
import stringCalculator.domain.Numbers;
import stringCalculator.domain.Operators;
import stringCalculator.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // 입력 및 계산
        String[] stringArray = InputView.inputOperationsAndNumber();
        for (int i = 0; i < stringArray.length; i++) {
            new StringCalculation(stringArray[i], i+1);
        }

        StringCalculation calculation = new StringCalculation();
        calculation.calculate();

        System.out.println(calculation.toString());

    }


}
