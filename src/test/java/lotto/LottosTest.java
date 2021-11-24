package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class LottosTest {
    @Test
    void getPrizeTest() {
        WinningNumbers winningNumber = new WinningNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        BonusBall bonus = new BonusBall(winningNumber,new Number(10));
        Lottos lottos = new Lottos(7000,
                () -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(lottos.getPrize(winningNumber, bonus)).isEqualTo(5000 * 7);
    }

    @Test
    void getCountTest() {
        WinningNumbers winningNumber = new WinningNumbers(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        BonusBall bonus = new BonusBall(winningNumber,new Number(10));
        Lottos lottos = new Lottos(7000,
                () -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(lottos.getCount(Prize.FOURTH, winningNumber, bonus)).isEqualTo(7);
    }

}
