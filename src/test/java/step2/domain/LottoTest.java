package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoNumber;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void checkNumberTest(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(input);
        });
    }
}