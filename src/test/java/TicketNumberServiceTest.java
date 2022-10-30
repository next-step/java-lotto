import domain.ticket.TicketNumberService;
import dto.lottery.LotteryTicket;
import dto.lottery.WinnerLotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketNumberServiceTest {
    private TicketNumberService ticketNumberService;
    private List<Integer> firstPrizeLotteryNumber;
    private List<Integer> noPrizeLotteryNumber;
    private WinnerLotteryTicket matchedWinnerLotteryTicket;
    private WinnerLotteryTicket unmatchedWinnerLotteryTicket;

    @BeforeEach
    public void init() {
        ticketNumberService = new TicketNumberService();

        firstPrizeLotteryNumber = List.of(1, 2, 3, 4, 5, 6);
        noPrizeLotteryNumber = List.of(11, 21, 31, 41, 15, 16);
        matchedWinnerLotteryTicket = new WinnerLotteryTicket(new LotteryTicket(List.of(1, 2, 3, 4, 5, 6)), 5);
        unmatchedWinnerLotteryTicket = new WinnerLotteryTicket(new LotteryTicket(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @Order(1)
    public void 복권번호생성() {
        List<LotteryTicket> lotteryTickets = ticketNumberService.generateLotteryTicketNumbers(1);

        for (int lotteryTicketNumber : lotteryTickets.get(0).getTicketNumbers()) {
            assertThat(lotteryTicketNumber).isBetween(1, 45);
        }
    }

    @Test
    @Order(2)
    public void 당첨번호확인_1등_당첨() {
        assertThat(ticketNumberService.verifyNumbers(6, firstPrizeLotteryNumber, matchedWinnerLotteryTicket)).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void 당첨번호확인_꼴등_당첨() {
        assertThat(ticketNumberService.verifyNumbers(0, noPrizeLotteryNumber, matchedWinnerLotteryTicket)).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void 당첨번호개수조회_1등_번호() {
        assertThat(ticketNumberService.countOfMatchedNumbers(firstPrizeLotteryNumber, matchedWinnerLotteryTicket)).isEqualTo(6);
    }

    @Test
    @Order(5)
    public void 당첨번호개수조회_꼴등_번호() {
        assertThat(ticketNumberService.countOfMatchedNumbers(noPrizeLotteryNumber, matchedWinnerLotteryTicket)).isEqualTo(0);
    }

    @Test
    @Order(6)
    public void 보너스번호일치여부_일치() {
        assertThat(ticketNumberService.hasBonusTicketNumber(new LotteryTicket(firstPrizeLotteryNumber), matchedWinnerLotteryTicket.getBonusTicketNumber())).isTrue();
    }

    @Test
    @Order(7)
    public void 보너스번호일치여부_불일치() {
        assertThat(ticketNumberService.hasBonusTicketNumber(new LotteryTicket(firstPrizeLotteryNumber), unmatchedWinnerLotteryTicket.getBonusTicketNumber())).isFalse();
    }
}
