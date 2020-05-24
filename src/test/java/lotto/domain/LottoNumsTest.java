package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumsTest {

    @DisplayName("로또번호의 갯수가 6개가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,7,10})
    void given_not_6_when_lotto_create_then_throw_exception(int numCount) {
        assertThatThrownBy(()-> LottoNums.of(getLottoNums(numCount )))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호의 갯수는 6개이다.")
    @Test
    void given_6_nums_when_lotto_create_then_success() {
        List<Integer> nums = getLottoNums(6);

        assertThat(LottoNums.of(nums).toList()).containsAll(nums);
    }

    @DisplayName("로또의 번호가 중복될경우 예외가 발생한다.")
    @Test
    void rotto_nums_not_duplicated(){
        List<Integer> duplicatedNums = Arrays.asList(1,1,1,1,1,1);

        assertThatThrownBy(()-> LottoNums.of(duplicatedNums))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> getLottoNums(int count) {
        return IntStream.range(1, count + 1)
            .mapToObj(value -> value)
            .collect(Collectors.toList());
    }
}
