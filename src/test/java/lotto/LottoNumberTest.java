package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @Test
    void 로또숫자_생성() {
        LottoNumber lottoNumber = LottoNumber.of(3);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -2, 100})
    void 범위를_벗어난_로또숫자_생성(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number));
    }

    @Test
    void 로또숫자_비교() {
        LottoNumber lottoNumber = LottoNumber.of(3);
        assertThat(lottoNumber.compareTo(LottoNumber.of(6))).isNegative();
    }

}
