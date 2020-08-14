package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("범위에 해당하지 않는 번호 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void notValidRangeTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @DisplayName("로또 번호 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 11, 39})
    void issuedLottoNumberTest(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }
}