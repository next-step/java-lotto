package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.WinningTicketSelector;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTicketMakerTest {

    private WinningTicketSelector winningTicketSelector = new WinningTicketSelector("1,2,3,4,5,6");

    @DisplayName("당첨 번호가 생성 되는지 테스트")
    @Test
    void winningNumbersTest(){
        assertThat(winningTicketSelector.getWinningNumbers().size()).isEqualTo(6);
    }

    @DisplayName("티켓들 당첨 여부 판단로직 작동하는지 테스트")
    @Test
    void checkWinningNumberCountTest(){
        List<Integer> officialWinningNumbers = new ArrayList<>();
        officialWinningNumbers.add(1);
        officialWinningNumbers.add(2);
        officialWinningNumbers.add(3);
        officialWinningNumbers.add(4);
        officialWinningNumbers.add(5);
        officialWinningNumbers.add(6);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        LottoTicket firstTicket = new LottoTicket(numbers);
        LottoTicket secondTicket = new LottoTicket(numbers);
        firstTicket.checkWinningTicket(officialWinningNumbers);
        secondTicket.checkWinningTicket(officialWinningNumbers);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(firstTicket);
        tickets.add(secondTicket);

        winningTicketSelector.findWinningTicket(tickets);
        assertThat(tickets.get(0).getPrizeResult() + tickets.get(1).getPrizeResult()).isEqualTo(10000);
    }

}
