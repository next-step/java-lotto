package nextstep.lotto.dto;

import java.util.Objects;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_ONLY_NUMBER;
import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_ONLY_POSITIVE_NUMBER;

public class InputNumber {

    private int number;

    public InputNumber(String inputValue) {
        try {
            this.number = Integer.parseInt(inputValue);
        } catch(NumberFormatException e) {
            throw new RuntimeException(INVALID_INPUT_ONLY_NUMBER);
        }

        if(this.number < 0){
            throw new RuntimeException(INVALID_INPUT_ONLY_POSITIVE_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber inputNumber = (InputNumber) o;
        return number == inputNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
