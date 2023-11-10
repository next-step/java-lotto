package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoValidatorTest {

    @Test
    void 입력된_숫자의_갯수가_6개가_아니라면_예외가_발생한다() {
        assertAll(
                () -> {
                    List<Integer> actual = null;
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                },
                () -> {
                    List<Integer> actual = List.of(1, 2);
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                },
                () -> {
                    List<Integer> actual = List.of(1, 2, 3, 4, 5, 6, 7);
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                }
        );
    }

    @Test
    void 입력된_숫자가_1에서_45의_사이가_아니라면_예외가_발생한다() {
        assertAll(
                () -> {
                    List<Integer> actual = List.of(1, 2, 3, 4, 5, 46);
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                },
                () -> {
                    List<Integer> actual = List.of(46, 47, 48, 49, 51, 52);
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                },
                () -> {
                    List<Integer> actual = List.of(0, 1, 2, 3, 4, 5);
                    assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
                }
        );
    }

    @Test
    void 입력된_숫자가_중복이_있으면_예외가_발생한다() {
        List<Integer> actual = List.of(1, 2, 3, 1, 5, 7);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(actual));
    }

}
