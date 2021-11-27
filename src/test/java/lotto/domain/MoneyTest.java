package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("금액 객체 생성 테스트")
    @Test
    void createMoney() {
        Money money = new Money(1000);

        assertThat(money).isNotNull();
    }
}
