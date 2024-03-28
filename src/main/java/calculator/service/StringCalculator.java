package calculator.service;

import calculator.code.MathSign;
import calculator.util.StringSplitter;
import calculator.util.Validator;

public class StringCalculator {

    private NumericCalculator numericCalculator = new NumericCalculator();

    public int result(String input) {
        String[] inputArray = generateStringArray(input);
        Validator.validateExpression(inputArray);

        int numberA = Integer.parseInt(inputArray[0]);
        int numberB;
        for (int index = 1; index < inputArray.length; index = index + 2){
            numberB = Integer.parseInt(inputArray[index + 1]);
            MathSign mathSign = MathSign.fromSign(inputArray[index]);
            numberA = numericCalculator.calculate(numberA, numberB, mathSign);
        }

        return numberA;
    }

    private String[] generateStringArray(String input){
        Validator.validateInput(input);
        return StringSplitter.splitWithSpace(input);
    }

}
