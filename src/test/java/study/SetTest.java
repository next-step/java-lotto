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
        //Given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("[요구사항 1] size()를 활용하여 set의 크기 확인")
    @Test
    void check_whether_size_is_three() {
        //Then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("[요구사항 2] parameterizedTest 활용하여 contains() 테스트")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(ints = {1, 2, 3})
    void check_elements_through_parameterizedTest(int input) {
        //Then
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("[요구사항 3] CsvSource 통해 여러 경우의 contains() 테스트")
    @ParameterizedTest(name = "{displayName} ==> input : {0}, result : {1}")
    @CsvSource({"1,true","2,true","3,true","4,false","0,false","5,false"})
    void check_elements_through_csvsource(int input, boolean expected) {
        //Then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
