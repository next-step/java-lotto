package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ConfirmationOfWinningTest {

    @Test
    void getRank_6개일치_1위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(1);
    }

    @Test
    void getRank_5개일치_2위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 7})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(2);
    }

    @Test
    void getRank_4개일치_3위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 7, 8})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(3);
    }

    @Test
    void getRank_3개일치_4위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 7, 8, 9})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(4);
    }

    @Test
    void getRank_2개일치_5위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 7, 8, 9, 10})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(5);
    }

    @Test
    void getRank_1개일치_5위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{1, 7, 8, 9, 10, 11})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(5);
    }

    @Test
    void getRank_0개일치_5위() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{7, 8, 9, 10, 11, 12})
                .collect(Collectors.toList()));

        int rank = ConfirmationOfWinning.getRank(winningLotto, lotto);

        assertThat(rank).isEqualTo(5);
    }

}
