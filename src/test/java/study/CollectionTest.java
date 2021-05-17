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

class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set은 중복을 허용하지 않으므로 1,1,2,3을 추가하면 size 3이 된다")
    @Test
    void check_collection_size() {
        // given
        int expectedSize = 3;

        // when
        int collectionSize = numbers.size();

        // then
        assertThat(collectionSize).isEqualTo(expectedSize);
    }

    @DisplayName("Set에 포함되는 값을 입력하면 true 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void check_collection_contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set에 포함되는 값을 입력하면 true, 포함하지않는 값을 입력하면 false 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void check_collection_contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
