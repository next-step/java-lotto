package lotto.domain;

import lotto.dto.ScoreBoardData;
import lotto.dto.ScoreData;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.domain.LottoBuyerGenerator.BUY_TICKET_COST;

public class LottoScoreBoard {
    private Map<LottoScore, Integer> scoreBoard;

    public LottoScoreBoard(List<LottoScore> scores) {
        scoreBoard = new LinkedHashMap<>();

        Arrays.stream(
            LottoScore.values()
        ).forEach(
            score -> scoreBoard.put(score, 0)
        );

        scores.stream().forEach(
            score -> scoreBoard.put(score, scoreBoard.get(score) + 1)
        );
    }

    public ScoreBoardData getScoreBoardData() {
        return new ScoreBoardData(
            scoreBoard.entrySet().stream().filter(
                board -> board.getKey() != LottoScore.NOTHING
            ).map(
                board -> new ScoreData(board.getKey(), board.getValue())
            ).collect(Collectors.toList()),
            calculateProfit()
        );
    }

    private double calculateProfit() {
        double profit = scoreBoard.entrySet().stream().mapToDouble(
            board -> board.getKey().getReward() * board.getValue()
        ).sum();

        int cost = scoreBoard.entrySet().stream().mapToInt(
            board -> board.getValue()
        ).sum();

        return profit / (cost * BUY_TICKET_COST);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoScoreBoard that = (LottoScoreBoard) o;
        return Objects.equals(scoreBoard, that.scoreBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreBoard);
    }
}
