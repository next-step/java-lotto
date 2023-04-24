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
        assertThat(Money.initMoney(3000))
                .isInstanceOf(Money.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000,3", "4999,4", "1001,1", "5001,5"})
    @DisplayName("로또 발행 개수")
    void lottoQuantityTest(int amount, int quantity) {
        Money money = Money.initMoney(amount);

        assertThat(money.getLottoQuantity())
                .isEqualTo(quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    @DisplayName("1000보다 작은 값을 보낼 때 에러 반환")
    void nullOrEmptyTest(int input) {
        assertThatThrownBy(() -> Money.initMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상 입력해주세요.");
    }

}