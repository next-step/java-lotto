package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoSellerTest {
    @Test
    void 입력받은_금액에_따라_구입하는_로또복권의_개수를_반환한다() {
        //Given
        int inputMoney = 14000;

        //When
        int lottoTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        //Then
        assertThat(lottoTicketsToBuy).isEqualTo(inputMoney / LottoSeller.PRICE_OF_A_LOTTO_TICKET);
    }

    @Test
    void 입력받은_금액이_로또복권_한_장_가격보다_낮을_경우_예외가_발생한다() {
        //Given
        int inputInsufficientMoney = 900;
        int inputNegativeNumber = -1;

        //When
        //Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoSeller.countLottoTickets(inputInsufficientMoney);
                    LottoSeller.countLottoTickets(inputNegativeNumber);
                }).withMessage(LottoSeller.ALERT_MISSING_MONEY);
    }

    @Test
    void 구입할_개수만큼_로또복권을_발행한다() {
        //Given
        int inputMoney = 14000;
        int numberOfTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        //When
        LottoTickets lottoTickets = LottoSeller.issueLottoTicket(numberOfTicketsToBuy);

        //Then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(numberOfTicketsToBuy);
    }

    @Test
    void 당첨번호와_일치한_번호_개수를_반환한다() {
        //Given
        List<Integer> testLuckyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LuckyTicket luckyTicket = LottoSeller.getLuckyNumber(testLuckyNumber, bonusNumber);

        List<Integer> matchesThreeNumbers = Arrays.asList(1, 3, 5, 7, 9, 11);
        LottoTicket ticketMatchesThreeNumbers = new LottoTicket(LottoTicketGenerator.pickLottoBalls(matchesThreeNumbers));

        //When
        long result = ticketMatchesThreeNumbers.getNumberOfMatchedToLuckyNumber(luckyTicket);

        //Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 당첨통계를_반환한다() {
        //Given
        List<Integer> testLuckyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LuckyTicket luckyTicket = LottoSeller.getLuckyNumber(testLuckyNumber, bonusNumber);

        List<Integer> matchesFourNumbers = Arrays.asList(1, 2, 3, 4, 7, 8);
        List<Integer> matchesFiveNumbers = Arrays.asList(1, 2, 3, 4, 5, 8);
        LottoTicket ticketMatchesFourNumbers = new LottoTicket(LottoTicketGenerator.pickLottoBalls(matchesFourNumbers));
        LottoTicket ticketMatchesFiveNumbers = new LottoTicket(LottoTicketGenerator.pickLottoBalls(matchesFiveNumbers));
        LottoTicket ticketMatchesSixNumbers = new LottoTicket(LottoTicketGenerator.pickLottoBalls(testLuckyNumber));

        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(ticketMatchesFourNumbers);
        lottoTickets.add(ticketMatchesFiveNumbers);
        lottoTickets.add(ticketMatchesSixNumbers);

        //When
        ResultSheet resultMap = ResultSheet.getResult(LottoTickets.from(lottoTickets), luckyTicket);

        //Then
        assertThat(resultMap.getResultMap().get(LottoRank.FIRST_PLACE)).isEqualTo(1);
        assertThat(resultMap.getResultMap().get(LottoRank.SECOND_PLACE)).isEqualTo(1);
        assertThat(resultMap.getResultMap().get(LottoRank.THIRD_PLACE)).isEqualTo(1);
    }
}
