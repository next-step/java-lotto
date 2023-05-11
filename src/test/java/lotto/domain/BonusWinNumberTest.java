package lotto.domain;

import lotto.domian.BonusWinNumber;
import lotto.domian.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusWinNumberTest {

    @DisplayName("보너스 볼의 범위가 1 ~ 45가 아니라면 예외를 던진다.")
    @Test
    public void bonusWinNumber_OutOfRange_ThrowException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusWinNumber(new LottoNumber(46)));
    }

}
