package step4.domain.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1", "45"})
    void 번호_생성_테스트(int input) {
        assertThat(new LottoNumber(input)).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "46"})
    void 번호_생성_테스트_오류(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"7, 7", "8, 8", "10, 10"})
    void 보너스_번호_존재_여부_True_테스트(int fistInput, int secondInput) {
        assertThat(new LottoNumber(fistInput).hasBonusNumber(secondInput)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"7, 8", "8, 7", "10, 11"})
    void 보너스_번호_존재_여부_False_테스트(int fistInput, int secondInput) {
        assertThat(new LottoNumber(fistInput).hasBonusNumber(secondInput)).isFalse();
    }
}
