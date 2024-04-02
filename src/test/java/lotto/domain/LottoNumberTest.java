package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 30, 45})
    public void 로또번호_생성(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또번호는_1이상_45이하_숫자만_가능(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("1이상 45이하의 숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void 로또번호_동등_여부(int number) {
        assertThat(LottoNumber.from(number)).isEqualTo(LottoNumber.from(number));

    }
}
