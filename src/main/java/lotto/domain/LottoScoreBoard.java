package lotto.domain;

import lotto.dto.ScoreBoardData;
import lotto.dto.ScoreData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.domain.LottoBuyerGenerator.BUY_TICKET_COST;

public class LottoScoreBoard {
    public static final int BIG_DECIMAL_SCALE = 2;
    private final Map<LottoScore, Integer> scoreBoard;

    public LottoScoreBoard(List<LottoScore> scores) {
        scoreBoard = new LinkedHashMap<>();

        Arrays.stream(
            LottoScore.values()
        ).forEach(
            score -> scoreBoard.put(score, 0)
        );

        scores.forEach(
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

    private BigDecimal calculateProfit() {
        BigDecimal profit = BigDecimal.valueOf(
            scoreBoard.entrySet().stream().mapToDouble(
                board -> board.getKey().getReward() * board.getValue()
            ).sum()
        );

        BigDecimal cost = BigDecimal.valueOf(
            scoreBoard.values().stream().mapToInt(
                count -> count
            ).sum()
        );

        return profit.divide(
            BigDecimal.valueOf(BUY_TICKET_COST).multiply(cost),
            BIG_DECIMAL_SCALE,
            BigDecimal.ROUND_CEILING
        );
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
