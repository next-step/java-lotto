package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPriceTest {
    @Test
    @DisplayName("로또 가격 정책 가져오기")
    void getPrice_fixedPrice_return1000() {
        int price = LottoPrice.getPrice();
        assertThat(price).isEqualTo(1000);
    }
}
