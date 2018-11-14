package net.chandol.lotto.domain;

import net.chandol.lotto.type.LottoPrize;
import net.chandol.lotto.value.WinningNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static net.chandol.lotto.value.LottoNumber.direct;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeCalculatorTest {

    @Test
    public void 로또1등당첨() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(direct(1, 2, 3, 4, 5, 6), 7);
        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winningNumber);

        LottoPrize prize = calculator.findPrize(lotto);
        assertThat(prize).isEqualTo(LottoPrize._1);
    }

    @Test
    public void 로또2개매칭확인() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(direct(5, 6, 7, 8, 9, 10), 45);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winningNumber);
        LottoPrize prize = calculator.findPrize(lotto);

        assertThat(prize).isEqualTo(LottoPrize.NONE);
    }

    @Test
    public void 로또결과확인() {
        WinningNumber winningNumber = new WinningNumber(direct(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(direct(3, 4, 5, 6, 7, 8)),
                new Lotto(direct(3, 4, 5, 6, 7, 8)),
                new Lotto(direct(1, 2, 5, 6, 7, 8)),
                new Lotto(direct(3, 7, 5, 6, 10, 11))
        );

        LottoPrizeCalculator calculator = new LottoPrizeCalculator(winningNumber);

        LottoGameResult result = calculator.lottoGameResult(lottos);

        assertThat(result.getProfitRate()).isEqualTo(38.75d);
        assertThat(result.getTotalPrize()).isEqualTo(155_000);
    }
}