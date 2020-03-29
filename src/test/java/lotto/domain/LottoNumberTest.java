package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @DisplayName("로또 숫자 생성")
    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void create(int expected) {
        LottoNumber actual = LottoNumber.valueOf(expected);
        assertThat(actual.getNumber()).isEqualTo(expected);
    }

    @DisplayName("로또 숫자가 정상 범위가 아닐시 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,46})
    void createFailByInvalidNumber(int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(expected));
    }
}