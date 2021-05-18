package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Set의 사이즈 확인")
    void testSetSize() {
        //given
        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set이 포함하고 있는 원소인지 확인")
    @ValueSource(ints = {1, 2, 3})
    void testSetContain(int number) {
        //given
        //when
        //then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set이 포함하고 있는 원소가 아닌 경우까지 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testSetContainTrueOrFalse(int number, boolean isContain) {
        //given
        //when
        //then
        assertThat(numbers.contains(number)).isEqualTo(isContain);
    }
}