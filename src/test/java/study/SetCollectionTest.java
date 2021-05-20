package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("요구사항1: set의 사이즈 확인")
    @Test
    public void validateSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @DisplayName("요구사항2: 파라미터 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void validateContains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("CsvSource 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void validateContains_byCsv(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
