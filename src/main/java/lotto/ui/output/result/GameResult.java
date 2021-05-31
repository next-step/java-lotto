package lotto.ui.output.result;

import lotto.core.rule.GameMoney;
import lotto.core.omr.Omr;
import lotto.core.omr.OmrCard;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.util.RateUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameResult {
    private final double totalPrice;
    private final double totalWinningMoney;
    private final Map<Rank, List<Omr>> result;

    public GameResult(OmrCard omrCard, Round round) {
        this.result = omrCard.grade(round);
        this.totalPrice = calcTotalPrice(omrCard);
        this.totalWinningMoney = calcTotalWinningMoney();
    }

    public double yields() {
        return RateUtils.getRate(totalPrice, totalWinningMoney);
    }

    public int totalCount(Rank rank) {
        if (rank.isDuplicateMatch()) {
            return duplicateMatchCount();
        }

        return count(rank);
    }

    private int duplicateMatchCount() {
        return Rank.duplicateMatchValues().stream()
            .mapToInt(rank -> count(rank))
            .sum();
    }

    private int count(Rank rank) {
        return Optional.ofNullable(result.get(rank))
            .orElse(Collections.EMPTY_LIST)
            .size();
    }

    private double calcTotalPrice(OmrCard omrCard) {
        return omrCard.size() * GameMoney.PRICE_OF_ONE_GAME;
    }

    private double calcTotalWinningMoney() {
        return result.keySet().stream()
                    .mapToInt(key -> result.get(key).size() * key.winningMoney())
                    .sum();
    }

}
