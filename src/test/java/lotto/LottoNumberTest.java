package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또번호를_생성한다() {
        assertThatCode(() -> new LottoNumber(1))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호는_0이하거나_46이상일수없다(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 숫자 범위는 1~45 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또번호는_1이상_45이하이다(int input) {
        assertThatCode(() -> new LottoNumber(input))
                .doesNotThrowAnyException();
    }


    @Test
    void 로또번호_6개_생성한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.lotto();
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 두_로또번호는_같은번호이다() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}
