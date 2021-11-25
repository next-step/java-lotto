package lotto;

import lotto.domain.*;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class PrizeTest {

    @Test
    @DisplayName("로또 맞춘 개수에 다른 상금 테스트")
    void prizeTest() {
        WinningLotto winningNumber = new WinningLotto("1,2,3,4,5,6");
        LottoNumber bonus = new LottoNumber(10);
        Lotto lotto = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        assertThat(Prize.findPrize(lotto.checkMatching(winningNumber), winningNumber, lotto.checkContainNumber(bonus))).isEqualTo(Prize.FIFTH);

        WinningLotto winningNumber1 = new WinningLotto("1,2,3,4,5,9");
        LottoNumber bonus1 = new LottoNumber(6);
        Lotto lotto1 = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(Prize.findPrize(lotto1.checkMatching(winningNumber1), winningNumber1, lotto1.checkContainNumber(bonus1))).isEqualTo(Prize.SECOND);

        WinningLotto winningNumber2 = new WinningLotto("11,12,13,14,15,19");
        LottoNumber bonus2 = new LottoNumber(6);
        Lotto lotto2 = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(Prize.findPrize(lotto2.checkMatching(winningNumber2), winningNumber2, lotto2.checkContainNumber(bonus2))).isEqualTo(Prize.ELSE);
    }
}

