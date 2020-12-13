package step1.domain.calculator;

import step1.domain.InputString;

import java.util.Arrays;

public class StringAddCalculator implements StringCalculator {

    @Override
    public int apply(InputString inputString) {
        return Arrays.stream(stringArrToIntArr(inputString.split())).sum();
    }
}
