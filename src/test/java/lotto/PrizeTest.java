package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Prize;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class PrizeTest {

    @Test
    @DisplayName("로또 맞춘 개수에 다른 상금 테스트")
    void prizeTest() {
        WinningNumbers winningNumber = new WinningNumbers("1,2,3,4,5,6");
        Number bonus = new Number(10);
        Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(Prize.findPrize(lotto, winningNumber, bonus)).isEqualTo(Prize.FOURTH);

        WinningNumbers winningNumber1 = new WinningNumbers("1,2,3,4,5,9");
        Number bonus1 = new Number(6);
        Lotto lotto1 = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        assertThat(Prize.findPrize(lotto1, winningNumber1, bonus1)).isEqualTo(Prize.BONUS_SECOND);
    }
}

