package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {
    @Test
    @DisplayName("범위의 Numbers객체 생성")
    void makeRangeNumbers() {
        Numbers numbers = Utils.makeRangeNumbers(0, 2);

        assertThat(numbers).isEqualTo(new Numbers(Arrays.asList(0, 1)));
    }
}
