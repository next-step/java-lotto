package lotto;

import lotto.domain.LottoEarningCalculator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoEarningCalculatorTest {

    final LottoTicket winningTicket = new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList()));
    final LottoNumber bonus = new LottoNumber(7);

    @Test
    void 당첨된_로또_확인_없을때() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(10, 11, 12, 13, 14, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).isEmpty();
    }

    @Test
    void 당첨된_로또_확인_5등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 13, 14, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).containsExactly(LottoPrize.FIFTH);
    }

    @Test
    void 당첨된_로또_확인_4등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 4, 14, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).containsExactly(LottoPrize.FORTH);
    }

    @Test
    void 당첨된_로또_확인_3등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 10).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).containsExactly(LottoPrize.THIRD);
    }

    @Test
    void 당첨된_로또_확인_2등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 7).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).containsExactly(LottoPrize.SECOND);
    }


    @Test
    void 당첨된_로또_확인_1등_1장() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).containsExactly(LottoPrize.FIRST);
    }

    @Test
    void 당첨된_로또_확인_여러장_당첨_5등_1개_4등_1개_3등_1개_2등_1개_1등_2개() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(Stream.of(1, 2, 3, 13, 14, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(1, 2, 3, 4, 14, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 15).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 7).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList())),
                new LottoTicket(Stream.of(20, 21, 22, 23, 24, 25).map(LottoNumber::new).collect(Collectors.toList()))
        );

        assertThat(LottoEarningCalculator.findPrize(tickets, winningTicket, bonus)).isEqualTo(
                List.of(LottoPrize.FIFTH, LottoPrize.FORTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST, LottoPrize.FIRST))
        ;
    }


    @Test
    void 당첨된_로또_없을때_수익률() {

        List<LottoPrize> prizes = new ArrayList<>();

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(0);
    }

    @Test
    void 로또_2장중_1장_5등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(LottoPrize.FIFTH);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(2.5f);
    }


    @Test
    void 로또_2장중_1장_4등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(LottoPrize.FORTH);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(25);
    }

    @Test
    void 로또_2장중_1장_3등_당첨시_수익률() {


        List<LottoPrize> prizes = List.of(LottoPrize.THIRD);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(750);
    }

    @Test
    void 로또_2장중_1장_2등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.SECOND);

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(15000);
    }

    @Test
    void 로또_2장중_1장_1등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(LottoPrize.FIRST);


        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 2)).isEqualTo(1000000);
    }

    @Test
    void 로또_10장중_1장_5등_당첨시_수익률() {

        List<LottoPrize> prizes = List.of(
                LottoPrize.FIFTH
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
    void 로또_10장중_2장_5등_1장_3등_당첨시_수익률() {
        List<LottoPrize> prizes = List.of(
                LottoPrize.FIFTH,
                LottoPrize.FIFTH,
                LottoPrize.THIRD
        );

        assertThat(LottoEarningCalculator.calculateEarningRate(prizes, 10)).isEqualTo(151);
    }
}
