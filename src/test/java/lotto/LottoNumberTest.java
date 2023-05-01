package lotto;

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
    @ValueSource(ints = {-1, 46})
    void 로또번호는_0이하거나_45를_초과할수없다(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 숫자 범위는 1~45 입니다.");
    }

    @Test
    void 로또번호_6개_생성한다() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.lotto();
        assertThat(lottoNumbers).hasSize(6);
    }
}
