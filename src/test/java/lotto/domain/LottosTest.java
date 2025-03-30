package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_등수() {
        Lottos lottos = new Lottos(List.of(Lotto.from("1,2,3,4,5,6"), Lotto.from("1,2,3,4,5,44")));
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1,2,3,4,5,12"), new Number(6));
        assertThat(winningLotto.ranks(lottos)).isEqualTo(new Ranks(List.of(Rank.SECOND, Rank.THIRD)));
    }

    @Test
    void 개수로_생성_시_검증() {
        Lottos lottos = Lottos.from(2);
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    void 개수로_생성_시_값_검증() {
        Lottos lottos = Lottos.from(2);
        assertThat(lottos.isAllValidRange()).isTrue();
    }

    @Test
    void 개수로_생성_시_정렬_검증() {
        Lottos lottos = Lottos.from(2);
        assertThat(lottos.isAllSorted()).isTrue();
    }

    @Test
    void 병합된_로또() {
        Lottos lottos1 = new Lottos(List.of(Lotto.from("1,2,3,4,5,6")));
        Lottos lottos2 = new Lottos(List.of(Lotto.from("11,12,13,14,15,16")));
        assertThat(lottos1.merged(lottos2)).isEqualTo(new Lottos(List.of(Lotto.from("1,2,3,4,5,6"), Lotto.from("11,12,13,14,15,16"))));
    }
}
