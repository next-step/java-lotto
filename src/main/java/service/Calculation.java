package service;

import domain.InputValues;
import enums.Operators;

public class Calculation {

    public int calculateInputValue(InputValues inputValues) {

        int result = Integer.parseInt(inputValues.getInputValues()[0]);

        for (int i = 1; i < inputValues.getInputValues().length - 1; i += 2) {
            result = Operators
                .findOperator(inputValues.getInputValues()[i])
                .operate(result, Integer.parseInt(inputValues.getInputValues()[i + 1]));
        }
        return result;
    }
}
