package study.lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static study.lotto.domain.ScoreType.*;

class ScoreBoardTest {

    @Test
    void 로또결과_숫자_한개_맞음() {
        ScoreBoard scoreBoard = new ScoreBoard(0);
        assertThat(scoreBoard.getScoreMap().get(ONE)).isEqualTo(0);

        // 하나 맞았음
        scoreBoard.addScore(ONE);
        assertThat(scoreBoard.getScoreMap().get(ONE)).isEqualTo(1);
    }

    @Test
    void 로또결과_숫자_다맞음() {
        ScoreBoard scoreBoard = new ScoreBoard(0);
        assertThat(scoreBoard.getScoreMap().get(SIX)).isEqualTo(0);

        scoreBoard.addScore(SIX);
        assertThat(scoreBoard.getScoreMap().get(SIX)).isEqualTo(1);
    }

    @Test
    void bigdecimal_add() {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(2);
        a = a.add(b);
        assertThat(a.intValue()).isEqualTo(3);
    }

    @Test
    void 상금_계산() {
        ScoreBoard scoreBoard = new ScoreBoard(10000);
        Map<ScoreType, Integer> scoreMap = scoreBoard.getScoreMap();

        scoreBoard.addScore(THREE);
        assertThat(scoreMap).containsEntry(THREE, 1);

        scoreBoard.addScore(FOUR);
        assertThat(scoreMap).containsEntry(THREE, 1);
        assertThat(scoreMap).containsEntry(FOUR, 1);

        scoreBoard.addScore(FIVE);
        assertThat(scoreMap).containsEntry(THREE, 1);
        assertThat(scoreMap).containsEntry(FOUR, 1);
        assertThat(scoreMap).containsEntry(FIVE, 1);

        scoreBoard.addScore(THREE);
        assertThat(scoreMap).containsEntry(THREE, 2);
        assertThat(scoreMap).containsEntry(FOUR, 1);
        assertThat(scoreMap).containsEntry(FIVE, 1);

        assertThat(scoreBoard.getTotalReward().intValue())
                .isEqualTo(THREE.getReward() +
                        THREE.getReward() +
                        FOUR.getReward() +
                        FIVE.getReward());
    }

}