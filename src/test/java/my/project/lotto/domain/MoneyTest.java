package my.project.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void createMoney(int money) {
        assertThat(new Money(money))
                .isNotNull()
                .isInstanceOf(Money.class);
    }

    @DisplayName("금액 미만 시 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {999})
    void givenInsufficientValue_thenThrowException(int money) {
        assertThatThrownBy(() -> new Money(money))
                .hasMessage("구입금액은 " + Money.PRICE + "원 이상입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("횟수 구하기")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void givenMoney_thenGetChances(int money) {
        assertThat(new Money(money).getChances()).isEqualTo(1);
    }

}