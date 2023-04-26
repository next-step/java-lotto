package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @CsvSource(value = {
            "1000,1",
            "5000,5",
            "12000,12",
    })
    @ParameterizedTest(name = "{0}원 -> {1}개")
    @DisplayName("로또 구입금액을 기준으로 N개의 로또를 생성합니다.")
    void test01(int purchasedAmount, int expected) {
        LottoTickets lottoTickets = LottoTickets.issue(new PurchasedAmount(purchasedAmount));
        assertThat(lottoTickets.size()).isSameAs(expected);
    }

}