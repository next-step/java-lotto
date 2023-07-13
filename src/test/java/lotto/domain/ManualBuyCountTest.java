package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualBuyCountTest {

    @Test
    @DisplayName("수동으로 구매할 로또 수 생성 테스트")
    void manualBuyCount_create() {
        Assertions.assertDoesNotThrow(() -> new ManualBuyCount(10, new Money("10000")));
    }
}
