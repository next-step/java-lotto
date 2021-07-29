package lotto.domain;

import lotto.exception.IllegalLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberTest {

    @DisplayName("로또 번호는 1보다 크거나 같고 45보다 작거나 같아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46", "1000"})
    void lotto_number_validation(String num) {
        assertThatThrownBy(() -> LottoNumber.of(num))
                .isInstanceOf(IllegalLottoNumberException.class);
    }

    @DisplayName("1부터 45 까지의 수중 of 로 만든 인스턴스는 같아야 한다.")
    @Test
    void number_of() {
        assertThat(LottoNumber.of("1") == LottoNumber.of("1")).isTrue();
        assertThat(new LottoNumber(1) == new LottoNumber(1)).isFalse();
    }
}
