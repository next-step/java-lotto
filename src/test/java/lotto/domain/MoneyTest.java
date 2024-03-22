package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @Test
    @DisplayName("Money 객체 설정 Test")
    void setMoney() {
        Money firstMoney = new Money("14000");
        Money secondMoney = new Money("14000");

        assertThat(firstMoney).isEqualTo(secondMoney);
    }

}