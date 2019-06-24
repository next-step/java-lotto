package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoSellerTest {
    @Test
    void 입력받은_금액에_따라_구입하는_로또복권의_개수를_반환한다() {
        //Given
        LottoSeller lottoSeller = new LottoSeller();
        int inputMoney = 14000;

        //When
        int lottoTicketsToBuy = lottoSeller.countLottoTickets(inputMoney);

        //Then
        assertThat(lottoTicketsToBuy).isEqualTo(inputMoney/LottoSeller.PRICE_OF_A_LOTTO_TICKET);
    }

    @Test
    void 입력받은_금액이_로또복권_한_장_가격보다_낮을_경우_예외가_발생한다() {
        //Given
        LottoSeller lottoSeller = new LottoSeller();
        int inputInsufficientMoney = 900;
        int inputNegativeNumber = -1;

        //When
        //Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lottoSeller.countLottoTickets(inputInsufficientMoney);
                    lottoSeller.countLottoTickets(inputNegativeNumber);
                }).withMessage(LottoSeller.ALERT_MISSING_MONEY);
    }

    @Test
    void 구입할_개수만큼_로또복권을_발행한다() {
        //Given
        LottoSeller lottoSeller = new LottoSeller();
        int inputMoney = 14000;
        int numberOfTicketsToBuy = lottoSeller.countLottoTickets(inputMoney);

        //When
        List<LottoTicket> lottoTickets = lottoSeller.issueLottoTicket(numberOfTicketsToBuy);

        //Then
        assertThat(lottoTickets.size()).isEqualTo(numberOfTicketsToBuy);
    }

    @Test
    void 당첨번호와_일치한_개수별로_당첨된_복권의_개수를_반환한다() {
//        //Given
//        LottoSeller lottoSeller = new LottoSeller();
//        List<Integer> testLuckyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
//        LuckyNumber luckyNumber = LuckyNumber.from(testLuckyNumber);
//
//        List<Integer> matchesThreeNumbers = Arrays.asList(1, 3, 5, 7, 9, 11);
//        LottoTicket ticketMatchesThreeNumbers = new LottoTicket(LottoTicketGenerator.pickLottoBalls(matchesThreeNumbers));
//
//        ticketMatchesThreeNumbers.getNumberOfMatchedToLuckyNumber(luckyNumber);
//
//        //When
//        lottoSeller.return
//        //Then
    }
}
