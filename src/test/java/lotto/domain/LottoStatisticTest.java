package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStatisticTest {

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 금액편")
    void statisticsAmount() {

        List<LottoTicket> lottoTickets = new ArrayList<>();

        int rottoPrice = 1000;

        lottoTickets.add(new LottoTicket("1,2,7,8,9,10")); // 미당첨
        lottoTickets.add(new LottoTicket("10,11,12,13,14,15")); // 미당첨
        lottoTickets.add(new LottoTicket("1,2,3,7,8,9")); // 5등  5000월
        lottoTickets.add(new LottoTicket("1,2,3,4,8,9")); // 4등  50000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,9")); // 3등  1500000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,7")); // 2등  30000000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); // 1등  2000000000

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);

        // 모든 등수
        long estimatedAmount = Arrays.stream(LottoRank.values())
                .mapToInt(value -> value.winningAmount)
                .sum();

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        LottoStatistic lottoStatistic = lottoMachine.initLottoStatistic(winningLottoTicket);

        assertThat(lottoStatistic.getTotalAmount()).isEqualTo(estimatedAmount);
    }

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 수익률편")
    void aggregationOfReturns() {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        int rottoPrice = 1000;

        lottoTickets.add(new LottoTicket("1,2,7,8,9,10")); // 미당첨
        lottoTickets.add(new LottoTicket("10,11,12,13,14,15")); // 미당첨
        lottoTickets.add(new LottoTicket("1,2,3,7,8,9")); // 5등  5000월
        lottoTickets.add(new LottoTicket("1,2,3,4,8,9")); // 4등  50000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,9")); // 3등  1500000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,7")); // 2등  30000000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); // 1등  2000000000

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);

        // 모든 등수
        BigDecimal estimatedAmount = new BigDecimal(Arrays.stream(LottoRank.values())
                .mapToInt(value -> value.winningAmount)
                .sum());

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        LottoStatistic lottoStatistic =lottoMachine.initLottoStatistic(winningLottoTicket);

        BigDecimal divisor = new BigDecimal(rottoPrice * lottoTickets.size());

        assertThat(lottoStatistic.getAggregationOfReturn())
                .isEqualTo(estimatedAmount.divide(divisor, 3, RoundingMode.HALF_UP).toString());
    }

    @Test
    @DisplayName("로또 당참된 갯수 리턴 확인")
    public void lottoRankMatchTest() {

        List<LottoTicket> lottoTickets = new ArrayList<>();

        int rottoPrice = 1000;

        lottoTickets.add(new LottoTicket("1,2,7,8,9,10")); // 미당첨
        lottoTickets.add(new LottoTicket("10,11,12,13,14,15")); // 미당첨
        lottoTickets.add(new LottoTicket("1,2,3,7,8,9")); // 5등  5000월
        lottoTickets.add(new LottoTicket("1,2,3,4,8,9")); // 4등  50000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,9")); // 3등  1500000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,7")); // 2등  30000000
        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); // 1등  2000000000

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 7);

        LottoMachine lottoMachine = new LottoMachine(rottoPrice * lottoTickets.size(), lottoTickets);

        LottoStatistic lottoStatistic =lottoMachine.initLottoStatistic(winningLottoTicket);

        assertThat(lottoStatistic.getLottoRankMatchCount(LottoRank.FIVE_PLACE)).isEqualTo(1);
        assertThat(lottoStatistic.getLottoRankMatchCount(LottoRank.FOUR_PLACE)).isEqualTo(1);
        assertThat(lottoStatistic.getLottoRankMatchCount(LottoRank.THREE_PLACE)).isEqualTo(1);
        assertThat(lottoStatistic.getLottoRankMatchCount(LottoRank.TWO_PLACE)).isEqualTo(1);
        assertThat(lottoStatistic.getLottoRankMatchCount(LottoRank.ONE_PLACE)).isEqualTo(1);
    }

}
