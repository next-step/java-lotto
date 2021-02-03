package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;
    private List<LottoTicket> lottoTickets;


    public void initLottoService() {
        lottoService = new LottoService();
    }

    public void initLottoServiceWithTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(LottoNumber.asList(Arrays.asList(1, 12, 23, 34, 25, 16))));
        lottoTickets.add(new LottoTicket(LottoNumber.asList(Arrays.asList(19, 28, 37, 41, 12, 1))));
        lottoService = new LottoService(lottoTickets);
    }

    @DisplayName("로또 구매 개수 확인 테스트")
    @Test
    public void buyLottoTicketsTest() {
        initLottoService();
        int numberOfTickets = 5;
        lottoService.buyLottoTickets(numberOfTickets);
        int size = lottoService.getLottoTickets().size();
        assertThat(size).isEqualTo(numberOfTickets);
    }

    @DisplayName("로또 결과 계산 테스트")
    @Test
    public void calculatePrizeTest() {
        initLottoServiceWithTickets();
        LotteryNumber lotteryNumber = new LotteryNumber(LottoNumber.asList(Arrays.asList(12, 1, 11, 13, 14, 23)), new LottoNumber(45));
        lottoService.recordLotteryNumber(lotteryNumber);
        lottoService.calculateResult();

        Map<Rank, Integer> expectedRankingStatus = new HashMap<>();
        expectedRankingStatus.put(Rank.FIRST, 0);
        expectedRankingStatus.put(Rank.SECOND, 0);
        expectedRankingStatus.put(Rank.THIRD, 0);
        expectedRankingStatus.put(Rank.FOURTH, 0);
        expectedRankingStatus.put(Rank.FIFTH, 1);
        expectedRankingStatus.put(Rank.NOTHING, 1);

        for (Rank rank : Rank.values()) {
            assertThat(expectedRankingStatus.get(rank))
                    .isEqualTo(lottoService.getLottoRankingStatus().get(rank));
        }
    }

    @DisplayName("로또 수익률 계산 테스트")
    @Test
    public void getInterestRateTest() {
        initLottoServiceWithTickets();

        LotteryNumber lotteryNumber = new LotteryNumber(LottoNumber.asList(Arrays.asList(12, 1, 11, 13, 14, 23)), new LottoNumber(45));
        lottoService.recordLotteryNumber(lotteryNumber);
        lottoService.calculateResult();

        assertThat(lottoService.getInterestRate()).isEqualTo(2.5);
    }
}
