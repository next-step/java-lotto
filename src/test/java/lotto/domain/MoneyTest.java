package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("천원이하의 금액은 존재할 수 없다.")
    void money() {
        assertThrows(IllegalArgumentException.class, () -> new Money(999));
    }

    @Test
    @DisplayName("천원 단위로 입력되어야 한다.")
    void money_2() {
        assertThrows(IllegalArgumentException.class, () -> new Money(1500));
    }

}
