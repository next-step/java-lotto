package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void lotto_normal() {
        List<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void lotto_최대값초과_argumentException() {
        List<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 46})
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_최소값미만_argumentException() {
        List<Integer> numbers = Arrays.stream(new Integer[]{0, 2, 3, 4, 5, 6})
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_숫자중복_argumentException() {
        List<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 5})
            .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void lotto_숫자6개이하_argumentException() {
        List<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4, 5})
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void getRank_6개일치_1위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));

        int rank = lotto.getRank(winningLotto);

        assertThat(rank).isEqualTo(1);
    }

    @Test
    void getRank_2개일치_5위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 9, 10, 11, 12})
                .collect(Collectors.toList()));

        int rank = lotto.getRank(winningLotto);

        assertThat(rank).isEqualTo(5);
    }

}
