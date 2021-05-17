package utils;

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

    @DisplayName("Set Collection 의 중복이제거된 크기 확인 테스트")
    @Test
    public void setCollectionSizeCheckTest() {
        int size = numbers.size();

        assertThat(numbers).hasSize(size);
        assertThat(numbers.size()).isEqualTo(size);
    }

    @DisplayName("set 에 값이 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsValueCheckTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("개선된 set 에 값이 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void improveContainsValueCheckTest(int input, boolean isContains) {
        assertThat(numbers.contains(input)).isEqualTo(isContains);
    }
}
