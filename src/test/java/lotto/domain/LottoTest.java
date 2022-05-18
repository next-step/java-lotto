package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void lotto_normal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers())
                .contains(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @Test
    void lotto_최대값초과_argumentException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_최소값미만_argumentException() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_숫자중복_argumentException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_숫자6개이하_argumentException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void getRank_6개일치_1위() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int rank = lotto.getRank(winningLotto);

        assertThat(rank).isEqualTo(1);
    }

    @Test
    void getRank_2개일치_5위() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 9, 10, 11, 12));

        int rank = lotto.getRank(winningLotto);

        assertThat(rank).isEqualTo(5);
    }

}
