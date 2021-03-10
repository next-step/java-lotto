package lotto;

import lotto.domain.LotteryTicket;
import lotto.domain.LotteryTicketList;
import lotto.dto.LotteryMatchResult;
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
    @DisplayName("로또리스트 전체 가격 테스트")
    void getTotalPrice() {
        int numberOfTickets = 15;
        int pricePerTicket = 1400;
        int expectedTotalPrice = numberOfTickets * pricePerTicket;

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addAutoBulk(numberOfTickets, pricePerTicket);

        assertThat(lottoTicketList.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }

    @Test
    @DisplayName("로또리스트 특정 로또티켓과 비교하여 결과값 도출 테스트")
    void match() {
        int price = 1000;
        LotteryTicket lastWinningTicket = new LotteryTicket(Arrays.asList(3, 5, 7, 10, 11, 12), price);

        List<Integer> lotteryNumberListWith2MatchingCount = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotteryNumberListWith4MatchingCount = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> lotteryNumberListWith6MatchingCount = Arrays.asList(3, 5, 7, 10, 11, 12);

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.add(lotteryNumberListWith2MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith4MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith6MatchingCount, price);

        LotteryMatchResult result = lottoTicketList.match(lastWinningTicket);

        assertThat(result.getLotteryTicketListByMatchingCount(0).size()).isEqualTo(0);
        assertThat(result.getLotteryTicketListByMatchingCount(2).size()).isEqualTo(1);
        assertThat(result.getLotteryTicketListByMatchingCount(4).size()).isEqualTo(1);
        assertThat(result.getLotteryTicketListByMatchingCount(6).size()).isEqualTo(1);

    }

}
