package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayLottoCountTest {

    @DisplayName("생성할때 0보다 작은 수가 주어지면 예외가 발생한다.")
    @Test
    void validate_less_than_zero() {
        assertThatThrownBy(() -> new PlayLottoCount(-1))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("0보다 작은 수로 생성할 수 없습니다.");
    }

    @DisplayName("인자값보다 작으면 true를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"14,false", "15,true"})
    void less_than(int value, boolean expected) {
        assertThat(new PlayLottoCount(14).isLessThan(value)).isEqualTo(expected);
    }

    @DisplayName("플레이로또 수 에서 ")
    @Test
    void subtract() {
        int actual = new PlayLottoCount(14).subtract(new PlayLottoCount(10));
        assertThat(actual).isEqualTo(4);
    }
}
