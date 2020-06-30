package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    private Money money;

    @DisplayName("입력 숫자가 1000미만일때 에러 발생")
    @Test
    void errorInput(){
        assertThrows(IllegalArgumentException.class, () -> {
            money = new Money(500);
        });
    }


}