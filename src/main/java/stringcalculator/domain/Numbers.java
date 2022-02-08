package stringcalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    //TODO userInput 네이밍 변경하기
    private final List<Integer> userInput;

    public Numbers(final List<Integer> userInput) {
        checkPositiveNumbers(userInput);
        this.userInput = userInput;

    }

    private void checkPositiveNumbers(final List<Integer> userInputs) {
        for (Integer userInput : userInputs) {
            checkPositiveNumber(userInput);
        }
    }

    private void checkPositiveNumber(Integer userInput) {
        if (userInput < 0) {
            throw new RuntimeException(String.format("inputValue: %d 양수의 값을 입력해 주세요.", userInput));
        }
    }

    public List<Integer> getNumberInput() {
        return new ArrayList<>(userInput);
    }
}

