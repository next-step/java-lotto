package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("정상 범위 내의 로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 30, 45})
    void validLottoNumber(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("정상 범위를 벗어난 로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidLottoNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
