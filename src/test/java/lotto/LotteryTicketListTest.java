package lotto;

import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicketList;
import lotto.domain.WinningLotteryTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketListTest {

    @Test
    @DisplayName("로또티켓리스트 생성 테스트")
    void create() {
        int numberOfTickets = 15;
        int pricePerTicket = 1200;

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addAutoBulk(numberOfTickets, pricePerTicket);
        assertThat(lottoTicketList.getTicketList().size()).isEqualTo(numberOfTickets);
    }

    @Test
    @DisplayName("로또티켓리스트 전체 가격 테스트")
    void getTotalPrice() {
        int numberOfTickets = 15;
        int pricePerTicket = 1400;
        int expectedTotalPrice = numberOfTickets * pricePerTicket;

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addAutoBulk(numberOfTickets, pricePerTicket);

        assertThat(lottoTicketList.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("로또티켓리스트 당첨로또티켓과 비교하여 결과값 도출 테스트")
    void match() {
        int price = 1000;
        WinningLotteryTicket lastWinningTicket = new WinningLotteryTicket(Arrays.asList(3, 5, 7, 10, 11, 12));

        List<Integer> lotteryNumberListWith2MatchingCount = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotteryNumberListWith4MatchingCount = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> lotteryNumberListWith6MatchingCount = Arrays.asList(3, 5, 7, 10, 11, 12);

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.add(lotteryNumberListWith2MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith4MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith6MatchingCount, price);

        List<LotteryPrize> result = lottoTicketList.match(lastWinningTicket);

        assertThat(result).contains(LotteryPrize.NONE);
        assertThat(result).contains(LotteryPrize.THIRD);
        assertThat(result).contains(LotteryPrize.FIRST);
    }
}
