package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RandomNumberUtilTest {

    @Test
    @DisplayName("랜덤 숫자를 확인한다")
    void generateRandomNumber() {
        //when
        Set<Integer> numbers = RandomNumberUtil.generateNumbers(10, 6);

        //then
        assertThat(numbers).doesNotContain(0, -1, 11, 12);
    }
}