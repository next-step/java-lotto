package calculator;

import calculator.domain.Calculation;
import calculator.view.InputView;

import java.util.List;

import static calculator.view.InputView.*;
import static calculator.view.ResultVIew.*;

public class CalculatorApplication {
    public static void main(String[] args) {
        String[] textArray = inputText();

        Calculation calculation = new Calculation(textArray);
        int result = calculation.startOperation();

        printResult(result);


    }
}
