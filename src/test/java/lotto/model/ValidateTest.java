package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateTest {
    @Test
    void numberValidate() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("s");
        });
    }
}
