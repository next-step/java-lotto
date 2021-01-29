package lotto.domain;

import lotto.dto.LottoGameProfitDTO;

import java.util.*;

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

        for(LottoScore score: scores) {
            scoreBoard.put(score, scoreBoard.get(score) + 1);
        }
    }

    public LottoGameProfitDTO calculateProfit() {
        double profit = scoreBoard.entrySet().stream().mapToDouble(
            board -> board.getKey().getReward() * board.getValue()
        ).sum();

        int cost = scoreBoard.entrySet().stream().mapToInt(
            board -> board.getValue()
        ).sum();

        return new LottoGameProfitDTO(
            profit / (cost * BUY_TICKET_COST)
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
