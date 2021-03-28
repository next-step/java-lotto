package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {


    @DisplayName("number 46이상일때, Exception 발생")
    @Test
    void isLottoNumber() {
        // GIVE
        // WHEN
        // THEN
        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int형을 String형으로 변환")
    @Test
    void getNumToString() {
        // GIVE
        Number number = new Number(3);
        // WHEN
        // THEN
        assertThat(number.getNumToString()).isEqualTo("3");
    }
}
