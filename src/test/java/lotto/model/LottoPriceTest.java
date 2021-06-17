package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPriceTest {
    private LottoPrice lottoPrice;

    @BeforeEach
    void setUp() {
        lottoPrice = new LottoPrice(5000);
    }

    @DisplayName(value = "로또 수량 계산하기")
    @Test
    void calculate_lotto_quantity() {
        assertThat(lottoPrice.calculateLottoQuantity()).isEqualTo(5);
    }
}
