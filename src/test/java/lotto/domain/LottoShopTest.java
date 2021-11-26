package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    private final LottoShop shop = new LottoShop();

    @DisplayName("구매 가능한 로또 개수 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1500,1"})
    void calculateCountAvailable(int money, int availableLottoCount) {
        assertThat(shop.calculateCountAvailable(money))
                .isEqualTo(availableLottoCount);
    }

    @DisplayName("구매 가능한 로또 개수 계산하기(돈이 부족한 경우_실패)")
    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    void calculateCountAvailable_zero_count_fail(int money) {
        assertThatThrownBy(() -> shop.calculateCountAvailable(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 금액으로는 로또를 사실 수 없습니다.");
    }

    @DisplayName("구매 가능한 로또 개수 계산하기(돈이 음수_실패)")
    @Test
    void calculateCountAvailable_fail() {
        assertThatThrownBy(() -> shop.calculateCountAvailable(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 금액으로는 로또를 사실 수 없습니다.");
    }

}
