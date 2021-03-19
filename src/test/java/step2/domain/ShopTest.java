package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.Money;
import step2.dto.ShopResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        this.shop = new Shop();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000:1:1",
            "1500:1:1",
            "2600:2:2"}, delimiter = ':')
    @DisplayName("살 수 있는 만큼의 로또를 살 수 있다")
    void canBuyLotto(int moneyAmount, int capacity, int expected) {
        Money money = new Money(moneyAmount);
        ShopResponse shopResponse = shop.buyLotto(money, capacity);
        assertThat(shopResponse.getLottoCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000:2",
            "1500:3",
            "2600:4"}, delimiter = ':')
    @DisplayName("살 수 없는 만큼의 로또를 사려 하면 예외를 던진다")
    void buyingInvalidNumberOfLottoThrowsException(int moneyAmount, int capacity) {
        Money money = new Money(moneyAmount);
        assertThrows(IllegalArgumentException.class, () -> shop.buyLotto(money, capacity));
    }

}
