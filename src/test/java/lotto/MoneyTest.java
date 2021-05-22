package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Money;

public class MoneyTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        // given
        Money money = new Money("1000");
        // when & then
        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test
    @DisplayName("금액 유효성 테스트")
    void validate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(900));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @Test
    @DisplayName("구매 가능 로또 수 반환 테스트")
    void countOfLotto() {
        // given
        Money money = new Money(14000);
        // when & then
        assertThat(money.countOfLotto()).isEqualTo(14);
    }
}

