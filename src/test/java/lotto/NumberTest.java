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
    void numberCreateTest() {
        List<Integer> numList = Arrays.asList(1, 5, 6, 9, 14, 20);
        Numbers numbers = new Numbers(numList);
        assertThat(numbers.getNumber()).containsExactly(1,5,6,9,14,20);
    }

    @Test
    void lengthValidationTest() {
        assertThatThrownBy(() ->new Numbers(Arrays.asList(1,5,6)))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void checkNumberRangeTest() {
        assertThatThrownBy(()->new Numbers(Arrays.asList(1,5,9,10,44,46)))
                .isInstanceOf(NotANumberException.class);
    }

    void checkDuplicateTest(){
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1,1,1,3,3,3)))
                .isInstanceOf(NumberDuplicateException.class);

    }
}
