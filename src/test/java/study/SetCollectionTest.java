package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 사이즈 테스트")
    void setSizeCheck() {
        assertThat(this.numbers).hasSize(3);
    }

    @DisplayName("contains() 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void containsCheck(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("contains() 다양한 실행결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "7:false", "3:true", "4:false"}, delimiter = ':')
    void containsTrueFalseCheck(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
