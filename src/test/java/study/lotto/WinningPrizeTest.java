package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.WinningPrize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {

    @DisplayName("당첨 목록 내림차순 출력")
    @Test
    public void winningPrizeValuesTest() {
        List<WinningPrize> winningPrizeList = Arrays.asList(WinningPrize.values());

        assertThat(winningPrizeList).containsExactly(WinningPrize.FOURTH, WinningPrize.THIRD, WinningPrize.SECOND,
                WinningPrize.FIRST);
    }

    @DisplayName("등수당 일치 개수, 당첨금액 확인")
    @Test
    public void winningPrizeTest() {
        assertThat(WinningPrize.FOURTH.matchCount()).isEqualTo(3);
        assertThat(WinningPrize.FOURTH.prize()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(WinningPrize.FIRST.matchCount()).isEqualTo(6);
        assertThat(WinningPrize.FIRST.prize()).isEqualTo(BigDecimal.valueOf(2000000000));
    }

}
