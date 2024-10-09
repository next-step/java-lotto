package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {10100, 1200, 2200})
    @DisplayName("총 로또 구매 가격 / 로또 장당 가격이 나누어 떨어지지 않을 때 예외가 발생한다.")
    void throwExceptionWhenTotalPriceNotDivisibleByTicketPrice(int totalPurchasePrice) {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(totalPurchasePrice);
        assertThatThrownBy(() -> new LottoTicket(lottoPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
    }

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
