package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {

    @Test
    @DisplayName("n개의 티켓 가격 계산")
    public void 티켓_가격_계산() {
        Assertions.assertThat(LottoSeller.price(4))
                .isEqualTo(4000);
    }

    @Test
    @DisplayName("입력된 돈에 따른 로또 티켓 갯수 계산")
    public void 티켓_갯수_계산() {
        Assertions.assertThat(LottoSeller.calculateTicketCount(4000))
                .isEqualTo(4);
    }
}
