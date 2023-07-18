package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoCountsTest {

    @Test
    void 로또_개수들_객체에서_전체_개수와_수동개수로_자동개수_정상계산() {
        // given
        LottoCounts lottoCounts = new LottoCounts(3, 2);

        // when
        int autoLottoCount = lottoCounts.getAutoLottoCount();

        // then
        assertThat(autoLottoCount).isEqualTo(1);
    }

    @Test
    void 로또_전체개수보다_수동개수가_많을시_예외발생() {
        // given, when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoCounts(1, 2));
        assertThat(exception).hasMessage("수동 로또의 개수는 전체 로또의 개수를 넘을 수 없습니다. 현재 입력값: 전체 로또 = " + 1
                + ", 수동 로또 = " + 2 + " 입니다.");
    }
}
