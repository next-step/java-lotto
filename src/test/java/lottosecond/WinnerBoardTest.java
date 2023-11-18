package lottosecond;

import lottosecond.domain.Winner;
import lottosecond.domain.WinnerBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class WinnerBoardTest {

    @Test
    @DisplayName("winnerBoard 에서 총 상금 금액을 계산해줍니다.")
    void calculateTotalPrice() {
        // given
        WinnerBoard winnerBoard = new WinnerBoard(List.of(Winner.FIRST, Winner.SECOND, Winner.FIFTH));
        // when
        long result = winnerBoard.calculateTotalPrice();
        // then
        Assertions.assertThat(result).isEqualTo(2_030_005_000L);
    }

}