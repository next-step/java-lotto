package net.chandol.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static net.chandol.lotto.domain.LottoNumber.direct;

public class LottoPrizeCalculatorTest {

    @Test
    public void 로또1등당첨() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));

        LottoPrizeCalculator calculator = new LottoPrizeCalculator(direct(1, 2, 3, 4, 5, 6));
        LottoPrize prize = calculator.findPrize(lotto);

        Assertions.assertThat(prize).isEqualTo(LottoPrize._1);
    }


    @Test
    public void 로또2개매칭확인() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));

        LottoPrizeCalculator calculator = new LottoPrizeCalculator(direct(5, 6, 7, 8, 9, 10));
        LottoPrize prize = calculator.findPrize(lotto);

        Assertions.assertThat(prize).isEqualTo(LottoPrize.NONE);
    }
}