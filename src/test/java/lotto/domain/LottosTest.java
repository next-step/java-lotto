package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.Price.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;

public class LottosTest {
    @Test
    void 당첨_등수() {
        Lottos lottos = new Lottos(List.of(Lotto.from("1,2,3,4,5,6"), Lotto.from("1,2,3,4,5,44")));
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1,2,3,4,5,12"), new Number(6));
        assertThat(winningLotto.ranks(lottos)).isEqualTo(new Ranks(List.of(Rank.SECOND, Rank.THIRD)));
    }

    @Test
    void 가격으로_생성_시_개수_검증() {
        Lottos lottos = Lottos.from(new Amount(2000));
        assertThat(lottos.size()).isEqualTo(2000 / LOTTO_PRICE);
    }

    @Test
    void 가격으로_생성_시_값_검증() {
        Lottos lottos = Lottos.from(new Amount(2000));
        assertThat(lottos.isAllValidRange()).isTrue();
    }

    @Test
    void 가격으로_생성_시_정렬_검증() {
        Lottos lottos = Lottos.from(new Amount(2000));
        assertThat(lottos.isAllSorted()).isTrue();
    }
}
