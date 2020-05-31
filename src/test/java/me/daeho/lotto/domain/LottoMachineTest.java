package me.daeho.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {
    private LottoNumberRule lottoNumberRule;
    private int unitPrice;
    private LottoMachine lottoMachine;

    @BeforeEach
    public void setup() {
        lottoNumberRule = RandomLottoNumber.create(LottoNumber.availableNumbers());
        unitPrice = 1000;
        lottoMachine = LottoMachine.create(lottoNumberRule, unitPrice);
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
    public void buyRandomTest() {
        List<LottoNumber> numbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        lottoMachine = LottoMachine.create(() -> numbers, unitPrice);
        List<LottoTicket> tickets = lottoMachine.buyRandom(1000);
        assertThat(tickets.size()).isEqualTo(1);
        assertThat(tickets.get(0).containsCount(numbers)).isEqualTo(6);
    }

    @Test
    public void earningRateTest() {
        double earningRate = lottoMachine.earningRate(5000, 10000);

        assertThat(earningRate).isEqualTo(2);
    }

    @Test
    public void totalPrizeTest() {
        Map<Rank, Integer> matchNumberCounts = new HashMap<Rank, Integer>() {{
            put(Rank.THIRD, 2);
            put(Rank.FIRST, 1);
        }};

        int totalPrize = lottoMachine.totalPrize(matchNumberCounts);

        int expectPrize = (Rank.THIRD.getPrize() * 2) + (Rank.FIRST.getPrize());
        assertThat(totalPrize).isEqualTo(expectPrize);
    }
}
