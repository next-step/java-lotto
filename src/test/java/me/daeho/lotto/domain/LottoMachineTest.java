package me.daeho.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private WinningPrize winningPrize;
    private int unitPrice;
    private LottoMachine lottoMachine;

    @BeforeEach
    public void setup() {
        winningPrize = WinningPrize.create()
                .setting(3, 5000)
                .setting(4, 50000)
                .setting(5, 1500000)
                .setting(6, 2000000000);
        unitPrice = 1000;
        lottoMachine = LottoMachine.create(unitPrice, winningPrize);
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

        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(11),
                LottoNumber.of(22),
                LottoNumber.of(33)
        );

        List<LottoTicket> tickets = Arrays.asList(
                LottoTicket.issue(lastWinningNumber),
                LottoTicket.issue(lottoNumbers)
        );

        Map<Integer,Integer> matchNumbers = lottoMachine.matchTicketCounts(lastWinningNumber, tickets);

        assertThat(matchNumbers.size()).isEqualTo(2);
        assertThat(matchNumbers.get(3)).isEqualTo(1);
        assertThat(matchNumbers.get(6)).isEqualTo(1);
    }

    @Test
    public void buyRandomTest() {
        List<LottoTicket> tickets = lottoMachine.buyRandom(14000);
        assertThat(tickets.size()).isEqualTo(14);
    }

    @Test
    public void earningRateTest() {
        double earningRate = lottoMachine.earningRate(5000, 10000);

        assertThat(earningRate).isEqualTo(2);
    }

    @Test
    public void totalPrizeTest() {
        Map<Integer, Integer> matchNumberCounts = new HashMap<Integer, Integer>() {{
            put(3, 2);
            put(6, 1);
        }};

        int totalPrize = lottoMachine.totalPrize(matchNumberCounts);

        int expectPrize = (winningPrize.prize(3) * 2) + (winningPrize.prize(6));
        assertThat(totalPrize).isEqualTo(expectPrize);
    }
}
