package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void purchaseLotto() {
        //given
        //LottoTickets lottoTickets = new LottoTickets();

        //when, then
        //assertThat(lottoTickets.purchaseLotto().size()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또들을 총 몇 개 맞췄는지 테스트")
    void checkLottoAnswer() {
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void calculateLottoRatio() {
        //given
        //LottoTickets lottoTickets = new LottoTickets();
        //int totalPrize = 70000;

        //when,then
        //assertThat(lottoTickets.calculateLottoRatio()).isEqualTo((double)totalPrize/(double)purchasePrice);
    }
}