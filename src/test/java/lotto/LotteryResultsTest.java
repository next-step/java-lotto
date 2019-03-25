package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryResultsTest {
    private LotteryResults lotteryResults;
    //4등티켓 2개와 3등 1개  2등 1개
    private List<LottoTicket> lottoTickets;
    private WiningLottoTicket winingLottoTicket;
    private int amount = 10000;


    @Before
    public void setUp() throws Exception {

        winingLottoTicket = new WiningLottoTicket(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        lottoTickets = new ArrayList<>();
        LottoTicket fourthTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 7, 8)); //4등 4개 번호동일
        LottoTicket fourthTicket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 5, 7, 8)); //4등 4개 번호동일
        LottoTicket ThirdTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 10));//3등   5개의번호 동일
        LottoTicket secondTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7));// 2등 5개의 번호동일 + 보너스넘버포함
        lottoTickets.add(fourthTicket);
        lottoTickets.add(fourthTicket2);
        lottoTickets.add(secondTicket);
        lottoTickets.add(ThirdTicket);
        lotteryResults = new LotteryResults(winingLottoTicket, lottoTickets, amount);
    }

    @Test
    public void 당첨_4등2개_3등1개_결과값에_플러스1() {
        assertThat(lotteryResults.getLottoResults().get(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lotteryResults.getLottoResults().get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    public void 당첨_4등_2개_2등_1개_3등_1개_일때_TotalPrize() {
        // 50000 + 50000 + 30_000_000 + 1_500_000    = 31600000
        assertThat(lotteryResults.getTotalPrize()).isEqualTo(31600000);
    }

    @Test
    public void 수익률_계산() {
        // 10000원을 투자,   31600000 원을 이득 보았을때
        double profit = lotteryResults.getProfit();

        // 10000원을 투자 31600000원을 을 이득보았을때 수익률
        // 50000 + 50000 + 30_000_000 + 1_500_000    = 31600000
        double amount = 10000;
        int total = LottoRank.FOURTH.getWinningMoney() + LottoRank.FOURTH.getWinningMoney() + LottoRank.THIRD.getWinningMoney()+ LottoRank.SECOND.getWinningMoney();

        assertThat(total / amount).isEqualTo(profit);
    }
}