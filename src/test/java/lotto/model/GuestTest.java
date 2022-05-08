package lotto.model;

import lotto.exception.MoneyNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GuestTest {

    @Test
    @DisplayName("1000원이하의 돈으로 로또를 구입 할 수 없습니다.")
    void lottoEmptySizeTest() {
        assertThrows(MoneyNumberException.class, () -> {
            Guest guest = new Guest(999);
        });
    }

}
