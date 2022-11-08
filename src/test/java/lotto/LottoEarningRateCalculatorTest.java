package lotto;

import lotto.domain.LottoEarningRateCalculator;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEarningRateCalculatorTest {
    @Test
    void 당첨된_로또_없을때_수익률() {

        List<LottoPrize> prizes = new ArrayList<>();

        assertThat(LottoEarningRateCalculator.calculate(prizes, 10)).isEqualTo(0);
    }

    @Test
    void 로또_2장중_1장_5등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(LottoPrize.FIFTH);

        assertThat(LottoEarningRateCalculator.calculate(prizes, 2)).isEqualTo(2.5f);
    }


    @Test
    void 로또_2장중_1장_4등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(LottoPrize.FORTH);

        assertThat(LottoEarningRateCalculator.calculate(prizes, 2)).isEqualTo(25);
    }

    @Test
    void 로또_2장중_1장_3등_당첨시_수익률() {


        List<LottoPrize> prizes = List.of(LottoPrize.THIRD);

        assertThat(LottoEarningRateCalculator.calculate(prizes, 2)).isEqualTo(750);
    }

    @Test
    void 로또_2장중_1장_2등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.SECOND);

        assertThat(LottoEarningRateCalculator.calculate(prizes, 2)).isEqualTo(15000);
    }

    @Test
    void 로또_2장중_1장_1등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.FIRST);


        assertThat(LottoEarningRateCalculator.calculate(prizes, 2)).isEqualTo(1000000);
    }

    @Test
    void 로또_10장중_1장_5등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(
                LottoPrize.FIFTH
        );

        assertThat(LottoEarningRateCalculator.calculate(prizes, 10)).isEqualTo(0.5f);
    }

    @Test
    void 로또_10장중_1장_1등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(
                LottoPrize.FIRST
        );

        assertThat(LottoEarningRateCalculator.calculate(prizes, 10)).isEqualTo(200000);
    }

    @Test
    void 로또_10장중_2장_5등_1장_3등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(
                LottoPrize.FIFTH,
                LottoPrize.FIFTH,
                LottoPrize.THIRD
        );

        assertThat(LottoEarningRateCalculator.calculate(prizes, 10)).isEqualTo(151);
    }
}
