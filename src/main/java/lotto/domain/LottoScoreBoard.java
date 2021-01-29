package lotto.domain;

import lotto.dto.LottoGameProfitDTO;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
}
