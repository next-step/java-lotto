package study;

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
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("SET의 크기를 리턴한다")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("입력된 값이 있는지 여부를 리턴한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("숫자가 포함되어있는지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsCheck(int number, boolean isContained) {
        assertThat(numbers.contains(number)).isEqualTo(isContained);
    }
}
