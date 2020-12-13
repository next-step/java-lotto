package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class AdderTest {

    @Test
    @DisplayName("덧셈 연산 테스트")
    void addTest() {
        assertThat(Adder.add(Collections.singletonList(1))).isEqualTo(1);
        assertThat(Adder.add(Arrays.asList(1, 2))).isEqualTo(3);
        assertThat(Adder.add(Arrays.asList(1, 2, 3))).isEqualTo(6);
        assertThat(Adder.add(Arrays.asList(1, 2, 3, 8))).isEqualTo(14);
    }
}
