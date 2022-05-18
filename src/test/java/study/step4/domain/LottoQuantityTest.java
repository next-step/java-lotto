package study.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 가격")
class LottoQuantityTest {

    @ParameterizedTest
    @CsvSource(value = {"11000, 11", "1000,1"})
    @DisplayName("로또 금액 대비 개수 확인")
    void 로또금액_대비_개수확인(int amount, int ticketCount) {
        LottoQuantity lottoQuantity = new LottoQuantity(amount, 0);

        assertThat(lottoQuantity.quantity()).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("로또 구매금액 천원미만 유효성 확인")
    void 로또_구매금액_천원미만_유효성_확인() {
        int amount = 0;

        assertThatThrownBy(() -> new LottoQuantity(amount, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}