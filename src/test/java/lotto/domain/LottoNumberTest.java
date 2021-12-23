package lotto.domain;

import lotto.exception.LottoApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {

    @Test
    @DisplayName("생성자 테스트: 1보다 거나 45보다 큰 수로 LottoNumber를 생성할 경우 LottoApplicationException 발생")
    void create() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoApplicationException.class);

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoApplicationException.class);
    }

    @Test
    @DisplayName("toString 테스트: 갖고있는 숫자의 문자열을 리턴한다.")
    void toStringTest() {
        int number = 1;

        LottoNumber lottoNumber = new LottoNumber(number);

        assertEquals(number+"", lottoNumber.toString());
    }

}
