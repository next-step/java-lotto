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
        purchasePrice = 7000;
        lottoPrice = 1000;
        lottoCount = purchasePrice / lottoPrice;
    }

    @Test
    @DisplayName("로또 티켓을 구매금액/로또가격 개수만큼 구매했는지 테스트")
    void addLottoTicket() {
        //given
        LottoTickets lottoTickets = new LottoTickets();

        //when
        lottoTickets.addLottoTicket(lottoCount, new Lotto());

        //then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또들을 총 몇 개 맞췄는지 테스트")
    void checkLottoAnswerMatch() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoCount, new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        //when
        Map<Integer, Integer> matchCount = lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));

        //then
        assertThat(matchCount.getOrDefault(5, 0)).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또들을 하나도 못 맞췄을 때 테스트")
    void checkLottoAnswerNonMatch() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoCount, new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        //when
        Map<Integer, Integer> matchCount = lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12)));

        //then
        assertThat(matchCount.getOrDefault(5, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 총 수익률 계산 테스트")
    void calculateLottoRatio() {
        //given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoCount, new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        //when
        lottoTickets.checkLottoAnswer(new ArrayList<>(Arrays.asList(1, 2, 3, 14, 15, 16)));
        lottoTickets.calculateLottoTotalPrize();

        //then
        assertThat(lottoTickets.calculateLottoRatio(purchasePrice))
                .isEqualTo(String.format("%.2f", (double) Prize.THREE_NUMBERS_PRIZE * lottoCount / (double) purchasePrice));
    }
}