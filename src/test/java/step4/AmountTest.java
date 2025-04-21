package step4;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

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

    @Test
    @DisplayName("금액 더하기 테스트")
    void amountAddTest() {
        Amount a = new Amount(1000);
        Amount b = new Amount(900);
        assertEquals(new Amount(1900), a.add(b));
    }

    @Test
    @DisplayName("금액 오버플로우 테스트")
    void amountOverflowTest() {
        Amount a = new Amount(2_000_000_000);
        assertEquals(BigInteger.valueOf(8_000_000_000L),a.multiplyByCount(4).getAmount());
    }
}
