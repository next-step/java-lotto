package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    @ParameterizedTest
    @ValueSource(ints = {MIN_NUMBER - 1 , MAX_NUMBER + 1})
    void newObject_InvalidNumber_throwsException(int invalidNumber) {
        assertThatThrownBy(
            () -> new LottoNumber(invalidNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
