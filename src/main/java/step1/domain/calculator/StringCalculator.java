package step1.domain.calculator;

import step1.domain.InputString;

import java.util.Arrays;

public interface StringCalculator {

    int apply(InputString inputString);

    default int[] stringArrToIntArr(String[] stringArr) {
        return Arrays.stream(stringArr)
                .mapToInt(Integer::parseInt)
                .map(num-> {
                    if (num<0) throw new RuntimeException();
                    return num;
                }).toArray();
    }
}
