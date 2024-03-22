package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.domain.LottoValidator.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("fromValidDuplicate 호출할 때 넘어오는 value가 LottoNumber에 이미 포함되면 IllegalArgumentException")
    void fromValidDuplicate_in_lottoNumber_exception(int input) {
        assertThatThrownBy(() -> MyNumber.bonusNumberFrom(input, dumpLottoNumber())).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 11, 12})
    @DisplayName("fromValidDuplicate 호출할 때 넘어오는 value가 LottoNumber에 포함되지 않으면 정상 생성")
    void fromValidDuplicate_not_in_lottoNumber(int input) {
        assertThat(MyNumber.bonusNumberFrom(input, dumpLottoNumber())).isInstanceOf(MyNumber.class);
    }

    @Test
    @DisplayName("fromValidDuplicate 호출할 때 넘어오는 value가 최솟값보다 작은 경우 IllegalArgumentException")
    void fromValidDuplicate_min_number_valid_exception() {
        int invalidNumber = MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> MyNumber.bonusNumberFrom(invalidNumber, dumpLottoNumber())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("fromValidDuplicate 호출할 때 넘어오는 value가 최대값보다 작은 경우 IllegalArgumentException")
    void fromValidDuplicate_max_number_valid_exception() {
        int invalidNumber = MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> MyNumber.bonusNumberFrom(invalidNumber, dumpLottoNumber())).isInstanceOf(IllegalArgumentException.class);
    }

    private LottoNumber dumpLottoNumber() {
        return LottoNumber.from(List.of(1, 2, 3, 4, 5, 6));
    }
}
