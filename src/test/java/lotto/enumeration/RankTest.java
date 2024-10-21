package lotto.enumeration;

import lotto.domain.InputNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static lotto.domain.Number.numbers;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 일치하는_개수로_당첨_금액_찾기() {
        assertThat(Rank.rank(new Lotto(LottoType.AUTO, numbers(1, 2, 3, 4, 5, 6)), new InputNumber("1, 2, 3, 4, 5, 6", "7"))).isEqualTo(Rank.FIRST);
    }
}