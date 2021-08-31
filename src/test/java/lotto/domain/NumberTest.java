package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호에 1이상 45이하의 수가 들어오지 않으면 Exception이 발생되어야 한다.")
    void lottoSaveNumberRangeTest(int input) {

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Number(input))
            .withMessageMatching("로또 번호는 1이상 45이하의 수만 들어올 수 있다.");
    }

}
