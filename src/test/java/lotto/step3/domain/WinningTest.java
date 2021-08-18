package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class WinningTest {

    @Test
    @DisplayName("보너스 볼이 당첨 번호에 포함되면 예외를 발생시킨다.")
    void isValidWinningLotto() {
        Lottery winningNumbers = LottoCreator.convertToLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> new Winning(winningNumbers, new LottoNumber(3))).isInstanceOf(IllegalArgumentException.class);
    }

}
