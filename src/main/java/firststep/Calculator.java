package firststep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int calculate(String[] input) {
        validate(input);
        return addNumbers(convertToIntegers(input));
    }

    private void validate(String[] input) {
        if(isNegativeNumber(input)) throw new RuntimeException();
    }

    private boolean isNegativeNumber(String[] input){
        boolean present;
        try {
            present = Arrays.stream(input).map(Integer::parseInt).filter(i -> i < 0).findFirst().isPresent();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return present;
    }

    private int addNumbers(List<Integer> input) {
        return input.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> convertToIntegers(String[] input) {
        return Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
    }
}

