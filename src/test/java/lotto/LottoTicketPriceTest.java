package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketPriceTest {
    @Test
    @DisplayName("구입금액에 맞게 구매한 로또 개수 출력")
    void 로또_구매() {
        assertThat(LottoTicketValidator.countByAmount(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("구입금액이 로또 금액보다 적은 금액인 경우")
    void 로또_구매_적은_금액() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoTicketValidator.countByAmount(900);
                }).withMessageMatching("지불한 금액이 로또 금액보다 적습니다.");
    }
}
