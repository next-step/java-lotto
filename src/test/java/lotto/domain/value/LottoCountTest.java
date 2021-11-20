package lotto.domain.value;

import lotto.exception.InvalidUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("100원 단위 입력시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "14100", "14300", "23100"
    })
    void validateMoneyUnit(String input) {
        assertThatThrownBy(() -> LottoCount.of(input)).isInstanceOf(InvalidUnitException.class);
    }

}