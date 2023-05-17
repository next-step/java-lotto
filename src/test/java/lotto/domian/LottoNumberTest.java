package lotto.domian;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("LottoNumber 1~45 가 아닌 경우 에러를 응답한다.")
    @Test
    public void lottoNumber_입력값_테스트() {

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
