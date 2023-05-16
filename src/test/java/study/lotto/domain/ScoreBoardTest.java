package study.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "ONE, TWO, 0",
            "ONE, SIX, 2_000_000_000",
            "ONE, BONUS, 30_000_000",
            "BONUS, SIX, 2_030_000_000",
    })
    void 상금_계산(ScoreType type1, ScoreType type2, Integer totalReward) {
        ScoreBoard scoreBoard = new ScoreBoard(10000);
        Map<ScoreType, Integer> scoreMap = scoreBoard.getScoreMap();
        scoreBoard.addScore(type1);
        scoreBoard.addScore(type2);
        assertThat(scoreBoard.getTotalReward().intValue()).isEqualTo(totalReward);
    }

    @Test
    void 보너스_볼이_추가된다() {
        ScoreBoard board = new ScoreBoard(1000);
        Map<ScoreType, Integer> scoreMap = board.getScoreMap();
        assertThat(scoreMap).containsEntry(ZERO, 0);
        assertThat(scoreMap).containsEntry(ONE, 0);
        assertThat(scoreMap).containsEntry(TWO, 0);
        assertThat(scoreMap).containsEntry(THREE, 0);
        assertThat(scoreMap).containsEntry(FOUR, 0);
        assertThat(scoreMap).containsEntry(FIVE, 0);
        assertThat(scoreMap).containsEntry(BONUS, 0);
        assertThat(scoreMap).containsEntry(SIX, 0);
    }

    @Test
    void _5개맞을때_보너스볼_유무에_따라_결과가_다르다() {
        ScoreBoard board = new ScoreBoard(1000);

    }
}