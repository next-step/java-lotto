package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Numbers;
import lotto.exception.NotANumberException;
import lotto.exception.NumberDuplicateException;
import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NumberTest {
    @Test
    void bonusNumberDuplicateTest() {
        Numbers numbers = new Numbers(Arrays.asList(1, 5, 6, 7, 8, 10));
        assertThatThrownBy(() -> numbers.addBonusNumber(10)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void numberCreateTest() {
        List<Integer> numList = Arrays.asList(1, 5, 6, 9, 14, 20);
        Numbers numbers = new Numbers(numList);
        assertThat(numbers.showNumbers()).containsExactly(1, 5, 6, 9, 14, 20);
    }

    @Test
    void lengthValidationTest() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 5, 6)))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void checkNumberRangeTest() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 5, 9, 10, 44, 46)))
                .isInstanceOf(NotANumberException.class);
    }

    @Test
    void checkDuplicateTest() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 1, 1, 3, 3, 3)))
                .isInstanceOf(NumberDuplicateException.class);

    }
}
