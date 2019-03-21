package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumbersTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_여섯_개_초과한_경우() {
        // given
        // when
        // then
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        new LottoNumbers(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_범위가_맞지_않는_경우() {
        // given
        // when
        // then
        final List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6, 7);
        new LottoNumbers(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된_로또_번호가_있는_경우() {
        // given
        // when
        // then
        final List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6, 7);
        new LottoNumbers(numbers);
    }

    @Test
    public void 로또_자동_생성() {
        // given
        // when
        // then
        LottoNumbers.randomNumbers();
    }
}
