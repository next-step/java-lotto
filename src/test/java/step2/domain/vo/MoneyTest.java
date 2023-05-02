package step2.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @Test
    void 구입금액이_0원보다_작을경우_예외를_던진다() {
        assertThrows(
                IllegalStateException.class,
                () -> new Money(-1000)
        );
    }
}