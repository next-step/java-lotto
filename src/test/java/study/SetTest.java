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
    @DisplayName("Set의 size 메소드를 활용해 set의 크기를 구할 수 있다.")
    public void Set의_size_메소드를_활용해_set의_크기를_구할_수_있다() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains 메소드를 활용해 값의 존재를 확인할 수 있다.")
    public void Set의_contains_메소드를_활용해_값으_존재를_확인할_수_있다(int containsNumber) {
        assertThat(numbers.contains(containsNumber))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource를 활용하여 Set의 contains 메소드를 활용해 값의 존재를 확인할 수 있다.")
    public void CsvSource를_활용하여_Set의_contains_메소드를_활용해_값의_존재를_확인할_수_있다(int containsNumber, boolean contains) {
        assertThat(numbers.contains(containsNumber))
                .isEqualTo(contains);
    }
}
