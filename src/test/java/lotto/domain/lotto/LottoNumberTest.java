package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호_하나를_생성한다(int lotto) {
        LottoNumber lottoNumber = new LottoNumber(lotto);
        assertThat(lottoNumber.value()).isEqualTo(lotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void 문자로_로또_번호를_생성할_수_있다(String lotto) {
        LottoNumber lottoNumber = new LottoNumber(lotto);
        int parseLotto = Integer.parseInt(lotto);
        assertThat(lottoNumber.value()).isEqualTo(parseLotto);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호는_1_이상_45_이하이다(int lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "1s"})
    void 숫자가_아닌_문자는_들어올_수_없다(String lotto) {
        assertThatThrownBy(() -> new LottoNumber(lotto))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
