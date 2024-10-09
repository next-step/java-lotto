package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14","1000:1","3000:3"}, delimiter = ':')
    @DisplayName("로또 구매 가격 만큼 로또를 발급한다.")
    void lottoCountTest(int purchasePrice, int count) {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(purchasePrice);
        LottoTicket lottoTicket = new LottoTicket(lottoPurchasePrice);
        assertThat(lottoTicket.getTicket()).hasSize(count);
    }

    @Test
    @DisplayName("getLottoWinningResult 메서드가 로또 결과 객체를 반환한다.")
    void getLottoWinningResultTest() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(1000);
        LottoTicket lottoTicket = new LottoTicket(lottoPurchasePrice);
        Lotto winningLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.getWinningResult(winningLotto))
                .isNotNull();
    }
}
