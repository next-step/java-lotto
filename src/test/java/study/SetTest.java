package study;

import org.junit.jupiter.api.BeforeEach;
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
    void size() {
        int size = numbers.size();
        assertThat(numbers).hasSize(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int element) {
        assertThat(numbers).contains(element);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void contains2(int element, boolean expected) {
        boolean actual = numbers.contains(element);
        assertThat(actual).isEqualTo(expected);
    }

}
