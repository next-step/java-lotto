package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoUtilTest {
    @Test
    void 구매_장수를_계산한다() {
        int 구매금액 = 14000;
        int 구매장수 = LottoUtil.calculateLottoQuantity(구매금액);
        assertThat(구매장수).isEqualTo(14);
    }

    @Test
    void 당첨번호_문자를_숫자리스트로_변환한다(){
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> winningNumbers = LottoUtil.convertWinningNumber(input);

        assertThat(winningNumbers).size().isEqualTo(6);
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);

    }
}