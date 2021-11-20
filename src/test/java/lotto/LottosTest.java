package lotto;

import lotto.domain.Number;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;
import lotto.domain.Lottos;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottosTest {
    @Test
    void getPrizeTest() {
        List<Number> winningNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Integer bonus = 10;
        Lottos lottos = new Lottos(7000,
                () -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(lottos.getPrize(winningNumber, bonus)).isEqualTo(5000 * 7);
    }

    @Test
    void getCountTest() {
        List<Number> winningNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Integer bonus = 10;
        Lottos lottos = new Lottos(7000,
                () -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(lottos.getCount(Prize.FOURTH, winningNumber, bonus)).isEqualTo(7);
    }

}
