package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private Money money;

    @DisplayName("입력 숫자가 1000미만일때 에러 발생")
    @Test
    void errorInput(){
        assertThrows(IllegalArgumentException.class, () -> {
            money = new Money(500);
        });
    }

    @DisplayName("한게임에 천원인 로또를 입력 10000원으로 몇개 살수 있는지")
    @Test
    void getBuyCount() {
        money = new Money(10000);
        int buyCount = money.getBuyCount();
        assertThat(buyCount).isEqualTo(10);
    }

    @DisplayName("한게임에 천원인 로또를  12345원으로 몇개 살수 있는지")
    @Test
    void getBuyCountWithSpecificType() {
        money = new Money(12345);
        int buyCount = money.getBuyCount();
        assertThat(buyCount).isEqualTo(12);
    }

}