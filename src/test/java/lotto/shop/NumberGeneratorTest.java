package lotto.shop;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    @Test
    @DisplayName("숫자 발생")
    void generate() {
        //given
        //when
        int[] number = NumberGenerator.generate();
        //then
        assertThat(number.length).isEqualTo(Lotto.MAX_COUNT);
    }

    @RepeatedTest(100)
    @DisplayName("숫자 유효성 체크")
    void checkNumber() {
        //given
        //when
        int[] numbers = NumberGenerator.generate();
        //then
        for (int number : numbers) {
            assertThat(number).isGreaterThan(0);
            assertThat(number).isLessThanOrEqualTo(45);
        }
    }
}
