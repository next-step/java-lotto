package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPriceTest {

    @Test
    @DisplayName("구입 금액에 따른 로또 개수 추출 기능")
    void numberOfTicket() {
        LottoPrice lottoPrice = new LottoPrice(2100);
        assertThat(lottoPrice.numberOfTicket())
                .isEqualTo(2);
    }
}
