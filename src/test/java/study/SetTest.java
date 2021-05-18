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

    //요구사항 1
    @Test
    @DisplayName("set의 size() 메서드 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    //요구사항 2-1
    @Test
    @DisplayName("set의 contains() 메서드 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    //요구사항 2-2 ( 소스의 중복제거 리팩토링 )
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void deduplication_contains(int data) {
        assertThat(numbers.contains(data)).isTrue();
    }

    //요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_both_true_and_false(String data,String expected) {
        assertThat(numbers.contains(Integer.parseInt(data))).isEqualTo(expected.equals("true"));
    }
}
