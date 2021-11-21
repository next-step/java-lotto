package lotto;

import lotto.domain.Lotto;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Prize;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class PrizeTest {

    @Test
    @DisplayName("로또 맞춘 개수에 다른 상금 테스트")
    void prizeTest() {
        List<Number> winningNumber = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Integer bonus = 10;
        Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)));
        assertThat(Prize.findPrize(lotto, winningNumber, bonus)).isEqualTo(Prize.FOURTH);
        List<Number> winningNumber1 = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(9));
        Integer bonus1 = 6;
        Lotto lotto1 = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        assertThat(Prize.findPrize(lotto1, winningNumber1, bonus1)).isEqualTo(Prize.BONUS_SECOND);
    }
}
