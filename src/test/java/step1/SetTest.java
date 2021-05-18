package step1;

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
    @DisplayName("set size 테스트")
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("set에 1,2,3이 포함되는지 체크")
    void contentCheckTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    @DisplayName("ParameterizedTest를 이용해서 중복 제거")
    void contentCheckTest2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value={"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @DisplayName("CsvSource를 이용해서 입력과 예상값으로 중복 제거")
    void contentCheckTest3(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }


}
