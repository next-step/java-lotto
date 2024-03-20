package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoValidator.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("valueOf 호출할 때 매개변수 리스트의 요소가 최솟값보다 작은 경우 IllegalArgumentException")
    void valueOf_min_number_valid_exception() {
        int invalidNumber = MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> BonusNumber.valueOf(invalidNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("valueOf 호출할 때 매개변수 리스트의 요소가 최대값보다 작은 경우 IllegalArgumentException")
    void valueOf_max_number_valid_exception() {
        int invalidNumber = MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> BonusNumber.valueOf(invalidNumber)).isInstanceOf(IllegalArgumentException.class);
    }

}
