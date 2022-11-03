package lotto;

import lotto.domain.LottoEarningCalculator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEarningCalculatorTest {

    LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 당첨된_로또_확인_없을때() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(10, 11, 12, 13, 14, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).isEmpty();
    }

    @Test
    void 당첨된_로또_확인_4등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 13, 14, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).containsExactly(LottoPrize.FORTH);
    }

    @Test
    void 당첨된_로또_확인_3등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 14, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).containsExactly(LottoPrize.THIRD);
    }

    @Test
    void 당첨된_로또_확인_2등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).containsExactly(LottoPrize.SECOND);
    }


    @Test
    void 당첨된_로또_확인_1등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).containsExactly(LottoPrize.FIRST);
    }

    @Test
    void 당첨된_로또_확인_여러장_당첨_4등_1개_3등_2개_2등_1개_1등_2개() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 13, 14, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(1, 2, 3, 4, 14, 15)),
                new LottoTicket(List.of(1, 2, 3, 4, 14, 15)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 16)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25)),
                new LottoTicket(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket)).isEqualTo(
                List.of(LottoPrize.FORTH, LottoPrize.THIRD, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST, LottoPrize.FIRST))
        ;
    }


    @Test
    void 당첨된_로또_없을때_수익률() {

        List<LottoPrize> prizes = new ArrayList<>();

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(0);
    }

    @Test
    void 로또_2장중_1장_4등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(LottoPrize.FORTH);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(2.5f);
    }

    @Test
    void 로또_2장중_1장_3등_당첨시_수익률() {


        List<LottoPrize> prizes = List.of(LottoPrize.THIRD);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(25);
    }

    @Test
    void 로또_2장중_1장_2등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.SECOND);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(750);
    }

    @Test
    void 로또_2장중_1장_1등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.FIRST);


        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(1000000);
    }

    @Test
    void 로또_10장중_1장_4등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(
                LottoPrize.FORTH
        );

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(0.5f);
    }

    @Test
    void 로또_10장중_1장_1등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(
                LottoPrize.FIRST
        );

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(200000);
    }

    @Test
    void 로또_10장중_2장_4등_1장_3등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(
                LottoPrize.FORTH,
                LottoPrize.FORTH,
                LottoPrize.THIRD
        );

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(6);
    }
}
