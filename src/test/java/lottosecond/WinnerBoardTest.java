package lottosecond;

import lottosecond.domain.WinnerBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class WinnerBoardTest {

    @Test
    @DisplayName("winnerBoard 에서 총 상금 금액을 계산해줍니다.")
    void calculateTotalPrice() {
        // given
        WinnerBoard winnerBoard = new WinnerBoard(Map.of(
                3, 2L,
                4, 1L,
                5, 0L,
                6, 0L
        ));
        // when
        int result = winnerBoard.calculateTotalPrice();
        // then
        Assertions.assertThat(result).isEqualTo(60000);
    }

}