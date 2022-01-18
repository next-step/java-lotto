package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {
    int purchasePrice;
    int lottoPrice;
    int lottoCount;

    @BeforeEach
    void setting() {
        purchasePrice = 2000;
        lottoPrice = 1000;
        lottoCount = purchasePrice / lottoPrice;
    }

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
    @DisplayName("로또들을 총 몇 개 맞췄는지 테스트")
    void checkLottoAnswerMatch() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));

        //when
        Map<Integer, Integer> matchCount = lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));

        //then
        assertThat(matchCount.getOrDefault(3, 0)).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또들을 하나도 못 맞췄을 때 테스트")
    void checkLottoAnswerNonMatch() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));

        //when
        Map<Integer, Integer> matchCount = lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18)));

        //then
        assertThat(matchCount.getOrDefault(3, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 총 수익률 계산 테스트")
    void calculateLottoRatio() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTickets.addLottoTicket(new Lotto(() -> new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));

        //when
        lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottoTickets.calculateLottoTotalPrize();

        //then
        assertThat(lottoTickets.calculateLottoRatio(purchasePrice)).isEqualTo("5.00");
    }

}