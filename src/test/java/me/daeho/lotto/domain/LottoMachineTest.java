package me.daeho.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {
    private RandomLottoNumberRule lottoNumberRule;
    private LottoMachine lottoMachine;

    @BeforeEach
    public void setup() {
        lottoNumberRule = ShuffleLottoNumber.create(LottoNumber.availableNumbers());
        lottoMachine = LottoMachine.create(lottoNumberRule, LottoPrice.defaultPrice());
    }

    @Test
    public void matchTicketCountsTest() {
        List<LottoNumber> lastWinningNumber = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        LottoNumber bonusBall = LottoNumber.of(7);

        List<LottoNumber> thirdLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(11),
                LottoNumber.of(22),
                LottoNumber.of(33)
        );

        List<LottoNumber> secondLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)
        );


        List<LottoTicket> tickets = Arrays.asList(
                LottoTicket.issue(secondLottoNumbers),
                LottoTicket.issue(lastWinningNumber),
                LottoTicket.issue(thirdLottoNumbers)
        );

        Map<Rank, Integer> rankCounts = lottoMachine
                .matchTicketCounts(lastWinningNumber, bonusBall, tickets);

        assertThat(rankCounts.size()).isEqualTo(3);
        assertTrue(rankCounts.containsKey(Rank.SECOND));
        assertTrue(rankCounts.containsKey(Rank.FIFTH));
        assertTrue(rankCounts.containsKey(Rank.FIRST));
    }

    @Test
    public void matchTicketCounts_null() {
        List<LottoNumber> lastWinningNumber = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        LottoNumber bonusBall = LottoNumber.of(7);

        List<LottoNumber> thirdLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(11),
                LottoNumber.of(22),
                LottoNumber.of(33)
        );

        List<LottoNumber> secondLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)
        );


        List<LottoTicket> tickets = Arrays.asList(
                LottoTicket.issue(secondLottoNumbers),
                LottoTicket.issue(lastWinningNumber),
                LottoTicket.issue(thirdLottoNumbers)
        );

        assertThatThrownBy(() -> lottoMachine.matchTicketCounts(null, bonusBall, tickets))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.matchTicketCounts(lastWinningNumber, null, tickets))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.matchTicketCounts(lastWinningNumber, bonusBall, null))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    public void earningRateTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)
        );

        LottoPurchase purchase = LottoPurchase.of(1_000,
                1,
                Collections.singletonList(LottoTicket.issue(lottoNumbers)
        ));

        TotalPrize totalPrize = TotalPrize.of(2000);

        EarningRate earningRate = lottoMachine.earningRate(purchase, totalPrize);

        assertThat(earningRate.value()).isEqualTo(2);
    }

    @Test
    public void earningRate_null() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)
        );

        LottoPurchase purchase = LottoPurchase.of(1_000,
                1,
                Collections.singletonList(LottoTicket.issue(lottoNumbers)
                ));

        TotalPrize totalPrize = TotalPrize.of(2000);

        assertThatThrownBy(() -> lottoMachine.earningRate(null, totalPrize))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.earningRate(purchase, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void totalPrizeTest() {
        Map<Rank, Integer> matchNumberCounts = new HashMap<Rank, Integer>() {{
            put(Rank.THIRD, 2);
            put(Rank.FIRST, 1);
        }};

        TotalPrize totalPrize = lottoMachine.totalPrize(matchNumberCounts);

        int expectPrize = (Rank.THIRD.getPrize() * 2) + (Rank.FIRST.getPrize());
        assertThat(totalPrize.value()).isEqualTo(expectPrize);
    }

    @Test
    public void totalPrize_null() {
        Map<Rank, Integer> rankCountNull = new HashMap<Rank, Integer>() {{
            put(Rank.THIRD, null);
        }};

        Map<Rank, Integer> rankNull = new HashMap<Rank, Integer>() {{
            put(null, 1);
        }};

        assertThatThrownBy(() -> lottoMachine.totalPrize(null))
                .isInstanceOf(IllegalArgumentException.class);

        TotalPrize totalPrize = lottoMachine.totalPrize(rankCountNull);
        assertThat(totalPrize.value()).isEqualTo(0);

        assertThatThrownBy(() -> lottoMachine.totalPrize(rankNull))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
