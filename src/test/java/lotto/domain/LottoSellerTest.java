package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {

    @DisplayName("입력한 만큼 로또 구매")
    @Test
    void buy() {
        List<Object> buy = LottoSeller.buy(5);
        assertThat(buy.size()).isEqualTo(5);
    }

    @Test
    void match() {
    }

}