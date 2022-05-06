package lotto.domain;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 40, 45})
    @DisplayName("생성 가능 범위에 속할 경우 해당 숫자로 로또 숫자 생성")
    void createLottoNumberTest(int value) {
        LottoNumber lottoNumber = new LottoNumber(value);
        assertThat(lottoNumber.toInt()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("생성 가능 범위 벗어날 경우 InvalidLottoNumberException 발생")
    void throwInvalidLottoNumberException(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("보너스 숫자와 같으면 true 반환")
    void isEqualToBonusNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(10);
        assertThat(lottoNumber.isEqualToBonusNumber(new LottoNumber(10))).isTrue();
        assertThat(lottoNumber.isEqualToBonusNumber(new LottoNumber(11))).isFalse();
    }
}
