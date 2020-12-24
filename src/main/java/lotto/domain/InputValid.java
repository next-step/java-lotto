package lotto.domain;

import java.util.List;

public class InputValid {
    private static final int LOTTO_LENGTH = 6;
    private static final int MIN_LOTTO_NUMBER = 0;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> inputNumbers;

    public InputValid(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;

        validInputNumberRange();
        validInputNumberLength();
    }

    public void validInputNumberRange() {
        inputNumbers.stream()
            .filter(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
            .forEach(number -> {
                throw new IllegalArgumentException("0보다 크고 46보다 작은 수를 입력해주세요.");
            });
    }

    public void validInputNumberLength() {
        if(inputNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("\n 6자리의 숫자를 입력해주세요.");
        }
    }
}
