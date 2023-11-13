package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    void 입력된_숫자가_1에서_45의_사이가_아니라면_예외가_발생한다() {
        assertAll(
                () -> {
                    int actual = 0;
                    assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(actual));
                },
                () -> {
                    int actual = -1;
                    assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(actual));
                },
                () -> {
                    int actual = 46;
                    assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(actual));
                }
        );
    }
}
