package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈은 1000원 단위여야한다.")
    @Test
    void money() {
        Assertions.assertThatThrownBy(() -> {
            new Money(900);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1000원 단위로 돈을 지불해주세요");
    }

    @DisplayName("수동로또를_뺀_나머지_금액 계산")
    @Test
    void money_수동로또를_뺀_나머지_금액() {
        Money money = new Money(13000, 5);

        int resultMoney = money.toInt();

        Assertions.assertThat(resultMoney).isEqualTo(8000);
    }
}