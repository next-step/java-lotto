package step2.domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 46, 999})
    void 로또번호가_1부터_45사이의_숫자가_아닐경우_예외를_던진다(int number) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Number(number)
        );
    }
}
