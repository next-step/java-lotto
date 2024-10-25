package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketValidatorTest {
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

    @Test
    @DisplayName("구매할 수 있는 로또 수보다 수동으로 구매할 로또가 더 많은 경우")
    void 수동_로또_개수_검증() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoTicketValidator.checkManualLottoCount(4, 5);
                }).withMessageMatching("구매할 수 있는 로또 수보다 수동으로 구매할 로또의 수가 더 많습니다.");
    }
}
