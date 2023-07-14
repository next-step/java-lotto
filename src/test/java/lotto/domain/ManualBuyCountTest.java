package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualBuyCountTest {

    @Test
    @DisplayName("수동으로 구매할 로또 수 생성 테스트")
    void manualBuyCount_create() {
        assertDoesNotThrow(() -> new ManualBuyCount(10, new Money("10000")));
    }

    @Test
    @DisplayName("입력 금액보다 더 많이 로또를 구매하려는 경우 테스트")
    void manualBuyCount_outOfRange() {
        assertThrows(IllegalArgumentException.class,
                () -> new ManualBuyCount(10, new Money("9999"))
        );
    }
}
