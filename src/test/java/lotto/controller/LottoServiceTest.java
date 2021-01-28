package lotto.controller;

import lotto.domain.LotteryNumber;
import lotto.domain.LottoService;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;
    private List<LottoTicket> lottoTickets;

    @BeforeEach
    public void beforeEach() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 구매 개수 확인 테스트")
    @Test
    public void buyLottoTicketsTest() {
        int numberOfTickets = 5;
        lottoService.buyLottoTickets(numberOfTickets);
        int size = lottoService.getLottoTickets().size();
        assertThat(size).isEqualTo(numberOfTickets);
    }

    @DisplayName("로또 결과 계산 테스트")
    @Test
    public void calculateLottoPrizeTest() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 12, 23, 34, 25, 16)));
        lottoTickets.add(new LottoTicket(Arrays.asList(19, 28, 37, 41, 12, 1)));
        LottoService lottoService = new LottoService(lottoTickets);

        LotteryNumber lotteryNumber = new LotteryNumber(Arrays.asList(12, 1, 11, 13, 14, 23), 45);
        lottoService.recordLotteryNumber(lotteryNumber);
        lottoService.calculatePrize();
    }


}
