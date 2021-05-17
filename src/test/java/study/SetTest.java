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

    @Test
    @DisplayName("set에 중복이 있는 경우 중복이 제거된 크기를 가진다.")
    void setSize_test() {
        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set에 저장된 값이 포함되있는지 검사한다.")
    void setContains_test(int input) {
        //then
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "5, false", "3, true", "10, false"})
    @DisplayName("set에 저장된 값이 포함 또는 포함되지 않는지 검사한다.")
    void set_contains_test(int input, boolean expect) {
        //then
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }
}
