package step4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.Amount;

public class AmountTest {
    @Test
    @DisplayName("금액 비교 테스트")
    void amountTest() {
        assertAll(
            () -> assertEquals(new Amount(1000), new Amount(1000)),
            () -> assertNotEquals(new Amount(900), new Amount(1000))
        );
    }
}
