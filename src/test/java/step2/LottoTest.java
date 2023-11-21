package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void checkNumberTest(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(input);
        });
    }
}