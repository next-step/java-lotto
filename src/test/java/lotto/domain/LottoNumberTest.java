package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @DisplayName("LottoNumber 객체의 동등성 비교 시 객체의 실제 값을 비교한다.")
    @Test
    void equals_to_value() {
        LottoNumber actual = new LottoNumber(1);

        assertThat(actual)
                .isEqualTo(new LottoNumber(1))
                .isNotSameAs(new LottoNumber(1));
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    @ParameterizedTest(name = "LottoNumber: {0}")
    @ValueSource(ints = {0, 46})
    void throw_IllegalArgumentException_when_lottoNumber_is_not_between_1_and_45(int given) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(given))
                .withMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }
}
