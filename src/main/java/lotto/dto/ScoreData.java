package lotto.dto;

import lotto.domain.LottoScore;

import java.util.Objects;

public class ScoreData {
    private final LottoScore score;
    private final Integer scoreCnt;

    public ScoreData(LottoScore score, Integer scoreCnt) {
        this.score = score;
        this.scoreCnt = scoreCnt;
    }

    public int getMatchedCnt() {
        return score.getMatchedCnt();
    }

    public boolean getIsBoundMatched() {
        return score.getIsBoundMatched();
    }

    public int getReward() {
        return score.getReward();
    }

    public int getScoreCnt() {
        return scoreCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreData scoreData = (ScoreData) o;
        return score == scoreData.score && Objects.equals(scoreCnt, scoreData.scoreCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, scoreCnt);
    }
}
