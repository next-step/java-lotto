package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1부터 45까지의 숫자")
    @ParameterizedTest
    @CsvSource({"1", "45"})
    public void create(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("숫자 범위 벗어나면 에러")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    public void createError(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

    @Test
    public void equalsTest() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }
}
