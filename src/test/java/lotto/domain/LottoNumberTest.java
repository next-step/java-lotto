package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {


    @Test
    @DisplayName("로또 숫자가 1-45사이가 아니면 에러를 던진다")
    void 로또숫자_validation() {
        int number = 46;

        Assertions.assertThatThrownBy(()-> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class );
    }
}
