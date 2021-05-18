package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @AfterEach
    void release() {
        numbers.clear();
    }

    @Test
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    public void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(5)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void containsWithValueSourceAnnotationTrueTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    public void containsWithValueSourceAnnotationFalseTest(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "5:false"}, delimiter = ':')
    public void containsWithCsvSourceAnnotationTest(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
