import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set size 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @DisplayName("Set contains 테스트 - valueSource 활용")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void containsWithValueSource(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set contains 테스트 - csvSource 활용")
    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "3,true", "4,false"})
    void containsWithCsvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
