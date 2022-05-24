package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 보너스번호일치() {
        LottoNumber lottoNumber = new LottoNumber(6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThat(lottoNumber.isSameNumber(bonusNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호유효성체크(int number) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
