import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("set 사이즈 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set에 있어야할 데이터가 있는지 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void contains(int data) {
        assertThat(numbers.contains(data)).isTrue();
    }

    @DisplayName("set에 있어야할 데이터와 없어야할 데이터가 알맞게 있는지 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains2(int data, boolean expected) {
        assertThat(numbers.contains(data)).isEqualTo(expected);
    }
}
