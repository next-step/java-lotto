package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("Money type 생성 테스트")
    void initMoneyTest() {
        assertThat(Money.from(3000))
                .isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000,3", "4999,4", "1001,1", "5001,5"})
    @DisplayName("로또 발행 개수")
    void lottoQuantityTest(int amount, int quantity) {
        Money money = Money.from(amount);

        assertThat(money.getLottoQuantity())
                .isEqualTo(quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    @DisplayName("1000보다 작은 값을 보낼 때 에러 반환")
    void nullOrEmptyTest(int input) {
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상 입력해주세요.");
    }

    @Test
    @DisplayName("Lotto 한장 구매 테스트")
    void lottoOnlyOneTest() {
        Money money = Money.from(1000);

        assertThat(money.getLottoQuantity())
                .isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8})
    @DisplayName("Lotto 구매 개수 초과 테스트")
    void isOverTotalQuantityTest(int amount) {
        Money money = Money.from(5000);

        assertThat(money.isOverTotalQuantity(amount))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("Lotto 구매 개수 가능 테스트")
    void isNotOverTotalQuantityTest(int amount) {
        Money money = Money.from(5000);

        assertThat(money.isOverTotalQuantity(amount))
                .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,5", "1,4", "2,3", "4,1", "5,0"})
    @DisplayName("Lotto 개수 계산 테스트")
    void getAutoLottosTest(int autoAmount, int manualAmount) {
        Money money = Money.from(5000);

        assertThat(money.getAutoLottoAmount(manualAmount))
                .isEqualTo(autoAmount);

    }

}