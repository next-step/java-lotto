package lottos.domain.numbers;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class NumbersTest {

    @Test
    @DisplayName("로또 번호는 6개가 아니면 오류")
    void size_incorrect_exception() {
        Assertions.assertThrows(LottoSizeIncorrectException.class, () -> Numbers.from(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 번호는 6개면 정상 생성")
    void size() {
        Assertions.assertDoesNotThrow(() -> Numbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 매치수_검증() {
        Numbers numbers1 = Numbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = Numbers.from(Arrays.asList(1, 2, 3, 4, 7, 8));

        int expect = numbers1.match(numbers2);
        Assertions.assertEquals(4, expect);
    }
}
