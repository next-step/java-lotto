package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 입력된_숫자의_갯수가_6개가_아니라면_예외가_발생한다() {
        assertAll(
            () -> {
                List<Integer> actual = null;
                assertThrows(IllegalArgumentException.class, () -> new LottoNumber(actual));
            },
            () -> {
                List<Integer> actual = List.of(1, 2);
                assertThrows(IllegalArgumentException.class, () -> new LottoNumber(actual));
            },
            () -> {
                List<Integer> actual = List.of(1, 2, 3, 4, 5, 6, 7);
                assertThrows(IllegalArgumentException.class, () -> new LottoNumber(actual));
            }
        );
    }
}
