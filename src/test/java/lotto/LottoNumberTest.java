package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @DisplayName("로또 번호가 1-45 사이의 수가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createFail(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(input));
    }

    @DisplayName("로또 번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(input);
    }

    @DisplayName("같은 로또 번호 동등 비교가 가능하다")
    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
