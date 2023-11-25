package step3.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    void 로또_번호_생성_테스트() {
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)).getNumbers()).hasSize(6);
    }

    @Test
    void 로또_번호_생성_테스트_오류() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호_존재_여부_True_테스트(int input) {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.hasBonusNumber(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"7", "8", "10"})
    void 보너스_번호_존재_여부_False_테스트(int input) {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.hasBonusNumber(input)).isFalse();
    }
}
