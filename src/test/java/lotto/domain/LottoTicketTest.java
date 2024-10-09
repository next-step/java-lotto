package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {10100, 1200, 2200})
    @DisplayName("총 로또 구매 가격 / 로또 장당 가격이 나누어 떨어지지 않을 때 예외가 발생한다.")
    void throwExceptionWhenTotalPriceNotDivisibleByTicketPrice(int totalPurchasePrice) {
        assertThatThrownBy(() -> new LottoTicket(totalPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14","1000:1","3000:3"}, delimiter = ':')
    @DisplayName("로또 구매 가격 만큼 로또를 발급한다.")
    void lottoCountTest(int purchasePrice, int count) {
        LottoTicket lottoTicket = new LottoTicket(purchasePrice);
        assertThat(lottoTicket.getTicket()).hasSize(count);
    }

//    @Test
//    @DisplayName("getLottoWinningResult 메서드가 올바른 로또 통계 정보를 반환한다.")
//    void getLottoWinningResultTest() {
//        var lottoResults = List.of(
//                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
//                new Lotto(Set.of(7, 8, 9, 10, 11, 12)),
//                new Lotto(Set.of(13, 14, 15, 16, 17, 18))
//        );
//        var winningNumbers = new Lotto(Set.of(1, 2, 3, 4, 5, 18));
//        LottoTicket lottoTicket = new LottoTicket(1000);
//
//        LottoWinningResults winningResult = lottoTicket.getWinningResult(winningNumbers);
//
//        assertThat(winningResult.getWinningResults().get(2).getCount())
//                .isEqualTo(1);
//    }
}
