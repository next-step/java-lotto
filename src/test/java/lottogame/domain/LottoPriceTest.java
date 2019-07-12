package lottogame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPriceTest {
    private LottoPrice price;

    @Test
    void price_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    price = new LottoPrice(500);
                });
    }

    @Test
    void countOflottoGame_check() {
        price = new LottoPrice(5000);
        assertThat(price.convertPriceToNumberOfGame()).isEqualTo(5);
    }
}