package lotto.stats;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.prize.Prize;
import lotto.domain.stats.PrizeBoard;
import lotto.domain.stats.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeBoardTest {

    @Test
    @DisplayName("Nothing Prize를 기록했을 때, Nothing Prize 승자 인원을 반환한다.")
    void addNonePrize() {
        PrizeBoard prizeBoard = new PrizeBoard();

        prizeBoard.record(Prize.NOTHING);

        assertThat(prizeBoard.getWinnerCountByPrize(Prize.NOTHING)).isEqualTo(1L);
    }

    @Test
    @DisplayName("1등 Prize를 기록했을 때, 1등 Prize 승자 인원을 반환한다.")
    void addFirstPrize() {
        PrizeBoard prizeBoard = new PrizeBoard();

        prizeBoard.record(Prize.FIRST);

        assertThat(prizeBoard.getWinnerCountByPrize(Prize.FIRST)).isEqualTo(1L);
    }

    @Test
    @DisplayName("2등 Prize를 2번 기록했을 때, 2등 Prize 승자 인원을 반환한다.")
    void addSecondPrize() {
        PrizeBoard prizeBoard = new PrizeBoard();

        prizeBoard.record(Prize.SECOND);
        prizeBoard.record(Prize.SECOND);

        assertThat(prizeBoard.getWinnerCountByPrize(Prize.SECOND)).isEqualTo(2L);
    }

    @Test
    @DisplayName("3등 Prize를 1번 기록했을 때, ScoreResult도 동일한 결과가 나타난다.")
    void getScoreResultTest() {
        PrizeBoard prizeBoard = new PrizeBoard();

        prizeBoard.record(Prize.THIRD);
        List<Score> scoreResult = prizeBoard.getScoreResult();
        Score score = scoreResult.stream()
                                 .filter(s -> s.getScore() == Prize.THIRD.getScore())
                                 .findAny().orElse(new Score());

        assertThat(score.getWinners()).isEqualTo(1L);
    }
}
