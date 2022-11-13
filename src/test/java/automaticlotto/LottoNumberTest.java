package automaticlotto;

import automaticlotto.automaticexception.InputValueException;
import automaticlotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("로또 범위 확인")
    @Test
    void lottoNumberTest() {
        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> new LottoNumber(46));
    }
}
