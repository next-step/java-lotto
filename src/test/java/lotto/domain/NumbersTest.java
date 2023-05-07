package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class NumbersTest {

    private List<Integer> originNumbers;

    @BeforeEach
    void makeNumbers(){
        originNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            originNumbers.add(i);
        }
    }

    @Test
    void 입력숫자6개초과시_예외처리() {
        originNumbers.add(7);
        assertThatThrownBy(() -> new Numbers(originNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오름차순정렬확인() {
        List<Integer> unSortedNumbers = Arrays.asList(33, 36, 32, 31, 34, 35);
        Numbers sortedNumbers = new Numbers(unSortedNumbers);
        List<Integer> numbers = sortedNumbers.getValues();
        assertAll (
                () -> assertThat(numbers).isEqualTo(List.of(31, 32, 33, 34, 35, 36)),
                () -> assertThat(numbers).containsExactly(31, 32, 33, 34, 35, 36)
        );
    }

    @ParameterizedTest(name = "{0}은 선택한 숫자가 맞음")
    @ValueSource(ints = {1,2,3,4,5,6})
    void 숫자포함테스트(int number) {
        Numbers numbers = new Numbers(originNumbers);
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "{0}은 선택한 숫자가 아님")
    @ValueSource(ints = {41,42,43,44,45})
    void 숫자불포함테스트(int number) {
        Numbers numbers = new Numbers(originNumbers);
        assertThat(numbers.contains(number)).isFalse();
    }
}
