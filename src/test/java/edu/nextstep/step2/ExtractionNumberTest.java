package edu.nextstep.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 22:57
 */
public class ExtractionNumberTest {

    private List<Number> numbers;

    @BeforeEach
    void setUp() {
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);
        numbers = new ArrayList<>(Arrays.asList(number1, number2, number3, number4, number5));

    }

    @DisplayName("리스트 size가 6으로 전달받아 생성하기 - 예외상황")
    @Test
    void validSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExtractionNumber exNumber = new ExtractionNumber(numbers);
        });
    }
}
