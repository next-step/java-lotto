package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.util.Price.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_개수() {
        Lottos lottos = new Lottos(List.of(Lotto.from(List.of(1,2,3,4,5,6)), Lotto.from(List.of(4,5,6,7,8,9))));
        assertThat(lottos.getMatchNums(Lotto.from(List.of(4,5,6,11,12,13)))).isEqualTo(Map.of(3, 2));
    }

    @Test
    void 가격으로_생성_시_개수_검증() {
        Lottos lottos = Lottos.from(2000);
        assertThat(lottos.getSize()).isEqualTo(2000 / LOTTO_PRICE);
    }

    @Test
    void 가격으로_생성_시_값_검증() {
        Lottos lottos = Lottos.from(2000);
        assertThat(lottos.isAllValidRange()).isTrue();
    }

    @Test
    void 가격으로_생성_시_정렬_검증() {
        Lottos lottos = Lottos.from(2000);
        assertThat(lottos.isAllSorted()).isTrue();
    }
}
