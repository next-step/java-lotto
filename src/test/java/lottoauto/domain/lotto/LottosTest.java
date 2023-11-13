package lottoauto.domain.lotto;

import lottoauto.domain.aggregate.WinnerBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("일치하는 당첨 로또들을 일치 수에 맞도록 winnerBoard 에 추가합니다.")
    void checkLotto() {
        // given
        Lottos lottos = LottosMaker.makeLottoList(() -> List.of(1, 2, 3, 4, 5, 6), 1000);
        WinnerBoard winnerBoard = new WinnerBoard();
        // when
        lottos.checkWinnerLotto(winnerBoard, List.of(1, 2, 3, 7, 8, 9));
        // then
        assertThat(winnerBoard).isEqualTo(new WinnerBoard(Map.of(
                3, 1,
                4, 0,
                5, 0,
                6, 0
        )));
    }

}