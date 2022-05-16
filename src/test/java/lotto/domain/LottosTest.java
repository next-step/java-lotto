package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class LottosTest {

    @Test
    void addLotto_normal() {
        Lotto lotto1 = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6})
                .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.stream(new Integer[]{7, 8, 9, 10, 11, 12})
                .collect(Collectors.toList()));

        Lottos lottos = new Lottos();
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);

        Assertions.assertThat(lottos.getCount()).isEqualTo(2);
    }

    @Test
    void getTotalRank_4등3개당첨_4등3개() {
        Lotto lotto1 = new Lotto(Arrays.stream(new Integer[]{1, 2, 3, 7, 8, 9})
                .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.stream(new Integer[]{10, 11, 12, 13, 14, 15})
                .collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Arrays.stream(new Integer[]{1, 7, 9, 12, 15, 17})
                .collect(Collectors.toList()));
        Lotto winningLotto = new Lotto(Arrays.stream(new Integer[]{7, 8, 9, 10, 11, 12})
                .collect(Collectors.toList()));

        Lottos lottos = new Lottos();
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);
        lottos.addLotto(lotto3);
        int[] totalRank = lottos.getTotalRank(winningLotto);

        Assertions.assertThat(totalRank[3]).isEqualTo(3);
    }
}
