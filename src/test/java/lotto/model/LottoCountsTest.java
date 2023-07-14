package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoCountsTest {

    @Test
    void 로또_개수들_객체에서_전체_개수와_수동개수로_자동개수_정상계산() {
        // given, when, then
        assertThat(new LottoCounts(3, 2).getAutoLottoCount()).isEqualTo(1);
    }

    @Test
    void 로또_전체개수보다_수동개수가_많을시_예외발생() {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> new LottoCounts(1, 2));
    }
}
