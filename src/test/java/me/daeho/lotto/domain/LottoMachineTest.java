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
        Map<Integer, Integer> matchNumberCounts = new HashMap<Integer, Integer>() {{
            put(3, 2);
            put(6, 1);
        }};

        int totalPrize = lottoMachine.totalPrize(matchNumberCounts);

        int expectPrize = (WinningPrize.getPrizeBy(3) * 2) + (WinningPrize.getPrizeBy(6));
        assertThat(totalPrize).isEqualTo(expectPrize);
    }
}
