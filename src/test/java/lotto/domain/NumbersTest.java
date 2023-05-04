package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
        List<Integer> unSortedNumbers = new ArrayList<>();
        unSortedNumbers.add(33);
        unSortedNumbers.add(36);
        unSortedNumbers.add(32);
        unSortedNumbers.add(31);
        unSortedNumbers.add(34);
        unSortedNumbers.add(35);

        Numbers numbers = new Numbers(unSortedNumbers);

        assertAll (
                () -> assertThat(numbers.find(0)).isEqualTo(31),
                () -> assertThat(numbers.find(1)).isEqualTo(32),
                () -> assertThat(numbers.find(2)).isEqualTo(33),
                () -> assertThat(numbers.find(3)).isEqualTo(34),
                () -> assertThat(numbers.find(4)).isEqualTo(35),
                () -> assertThat(numbers.find(5)).isEqualTo(36)
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

    @Test
    void 자동생성테스트() {
        Numbers numbers = Numbers.auto();
        assertAll(
                () -> assertThat(numbers.count()).isEqualTo(LottoRule.CHOICE_COUNT),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(0))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(1))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(2))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(3))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(4))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(numbers.find(5))).isTrue()
                );
    }
}
