package lotto.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {


    @Test
    void validNumberRange_test() {
        String inputNumber = "50,1,2";
        String[] inputNumberArray = inputNumber.split(",");

        assertThatIllegalArgumentException().isThrownBy(() ->
            Arrays.stream(inputNumberArray).filter(s -> (Integer.parseInt(s) > 0 && Integer.parseInt(s) > 45)).forEach(s -> {
                throw new IllegalArgumentException("0보다 크고 46보다 작은 수를 입력해주세요.");
            })
        );
    }

    @Test
    void validNumberLength_test() {
        String inputNumber = "4,1,2";
        String[] inputNumberArray = inputNumber.split(",");

        if(inputNumberArray.length != 6) {
            throw new IllegalArgumentException("\n 6자리의 숫자를 입력해주세요.");
        }
    }
}