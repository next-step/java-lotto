package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("입력된 돈에 따른 로또 티켓 갯수 계산")
    public void 티켓_갯수_계산() {
        Assertions.assertThat(Lotto.calculateTicketCount(4000))
                .isEqualTo(4);
    }

    @Test
    @DisplayName("n개의 티켓 가격 계산")
    public void 티켓_가격_계산() {
        Assertions.assertThat(Lotto.price(4))
                .isEqualTo(4000);
    }
}
