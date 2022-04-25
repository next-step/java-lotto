package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGenerateUtilTest {

    @Test
    @DisplayName("랜덤 숫자 Set 반환")
    void returnIntegerSetSizeSix() {
        Set<Integer> integers = NumberGenerateUtil.generateNumbers(5, 3);
        assertThat(integers).doesNotContain(0, 6, -1).hasSize(3);
    }

}