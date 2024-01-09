package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1이하 ,45이상인 수면 exception을 발생시킨다.")
    void test1() {

        String expectingMessage = "0보다 크고, 46보다 작은 수를 입력해주세요";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumber.of(0))
            .withMessageMatching(expectingMessage);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumber.of(46))
            .withMessageMatching(expectingMessage);
    }
}
