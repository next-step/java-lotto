package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {

    /*
    @Test
    @DisplayName("로또 티켓을 구매금액/로또가격 개수만큼 구매했는지 테스트")
    void addLottoTicket() {
        //given
        LottoTickets lottoTickets = new LottoTickets();

        //when
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        //then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(2);
    }


    @Test
    @DisplayName("로또 총 수익률 계산 테스트")
    void calculateLottoRatio() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));
        AnswerLotto answerLotto = new AnswerLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));

        //when
        answerLotto.checkLottoAnswer(lottoTickets.getLottoTickets());
        lottoTickets.calculateLottoTotalPrize();

        //then
        assertThat(lottoTickets.calculateLottoRatio(2000)).isEqualTo("5.00");
    }
     */
}