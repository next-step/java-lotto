package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber은 매번 메모리 캐시에서 가져온 동일한 객체이다.")
    void getLottoInstanceTest() {
        assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();

    }

    @Test
    @DisplayName("String 인자를 넣어 가져온 LottoNumber도 매번 동일한 객체이다.")
    void getLottoInstanceFromStringParameterTest() {
        assertThat(LottoNumber.of("2") == LottoNumber.of(2)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void invalidLottoNumberTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}