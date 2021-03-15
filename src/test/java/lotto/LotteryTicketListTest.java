package lotto;

import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicketList;
import lotto.domain.WinningLotteryTicket;
import lotto.dto.ManualLotteryNumberListDto;
import lotto.dto.LotteryTicketListDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketListTest {

    @Test
    @DisplayName("로또티켓리스트 자동생성 테스트")
    void create_auto() {
        int numberOfTickets = 15;
        int pricePerTicket = 1200;

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addAutoBulk(numberOfTickets, pricePerTicket);

        assertThat(lottoTicketList.getTicketList().totalSize()).isEqualTo(numberOfTickets);
    }


    @Test
    @DisplayName("로또티켓리스트 수동생성 테스트")
    void create_manual() {
        int pricePerTicket = 1200;
        List<ManualLotteryNumberListDto> listOfManualLotteryNumberList = Arrays.asList(new ManualLotteryNumberListDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new ManualLotteryNumberListDto(Arrays.asList(12, 14,15, 17, 18, 19)));

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addManualBulk(listOfManualLotteryNumberList,pricePerTicket);
        assertThat(lottoTicketList.getTicketList().totalSize()).isEqualTo(listOfManualLotteryNumberList.size());
    }


    @Test
    @DisplayName("로또티켓리스트 자동수동생성 테스트")
    void create_mixed() {
        int pricePerTicket = 1200;
        List<ManualLotteryNumberListDto> listOfManualLotteryNumberList = Arrays.asList(new ManualLotteryNumberListDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new ManualLotteryNumberListDto(Arrays.asList(12, 14,15, 17, 18, 19)));
        int numberOfAutoTickets = 15;

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.addManualBulk(listOfManualLotteryNumberList,pricePerTicket);
        lottoTicketList.addAutoBulk(numberOfAutoTickets,pricePerTicket);

        LotteryTicketListDto ticketList = lottoTicketList.getTicketList();

        assertThat(ticketList.autoSize()).isEqualTo(numberOfAutoTickets);
        assertThat(ticketList.manualSize()).isEqualTo(listOfManualLotteryNumberList.size());
        assertThat(ticketList.totalSize()).isEqualTo(listOfManualLotteryNumberList.size() + numberOfAutoTickets);
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
        WinningLotteryTicket lastWinningTicket = new WinningLotteryTicket(Arrays.asList(3, 5, 7, 10, 11, 12), 18);

        List<Integer> lotteryNumberListWith2MatchingCount = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotteryNumberListWith4MatchingCount = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> lotteryNumberListWith5MatchingCountWithNoBonusNumber = Arrays.asList(7, 18, 5, 10, 11, 12);
        List<Integer> lotteryNumberListWith5MatchingCountWithOutBonusNumber = Arrays.asList(7, 22, 5, 10, 11, 12);
        List<Integer> lotteryNumberListWith6MatchingCount = Arrays.asList(3, 5, 7, 10, 11, 12);

        LotteryTicketList lottoTicketList = new LotteryTicketList();
        lottoTicketList.add(lotteryNumberListWith2MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith4MatchingCount, price);
        lottoTicketList.add(lotteryNumberListWith5MatchingCountWithNoBonusNumber, price);
        lottoTicketList.add(lotteryNumberListWith5MatchingCountWithOutBonusNumber, price);
        lottoTicketList.add(lotteryNumberListWith6MatchingCount, price);

        lottoTicketList.setLotteryPrize(lastWinningTicket);
        LotteryTicketListDto ticketList = lottoTicketList.getTicketList();

        assertThat(ticketList.getLotteryPrizeCount(LotteryPrize.NONE))
                .isEqualTo(1);
        assertThat(ticketList.getLotteryPrizeCount(LotteryPrize.FOURTH))
                .isEqualTo(1);
        assertThat(ticketList.getLotteryPrizeCount(LotteryPrize.SECOND))
                .isEqualTo(1);
        assertThat(ticketList.getLotteryPrizeCount(LotteryPrize.THIRD))
                .isEqualTo(1);
        assertThat(ticketList.getLotteryPrizeCount(LotteryPrize.FIRST))
                .isEqualTo(1);
    }

}
