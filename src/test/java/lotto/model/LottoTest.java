package lotto.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 로또_번호_입력() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    public void 로또_번호_매치() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 20, 21);

        Lotto lotto = new Lotto(numbers);
        Lotto winnerLotto = new Lotto(winnerNumbers);

        int matchCount = lotto.matchCount(winnerLotto);

        assertThat(matchCount).isEqualTo(4);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_중복_숫자_입력() {
        List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 5, 2);
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_1_45_범위에_벗어난_숫자_입력() {
        List<Integer> numbers = Arrays.asList(1, 47, 3, 4, 5, 2);
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자가_6개_미만_입력() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_숫자가_6개_초과_입력() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        new Lotto(numbers);
    }


}
