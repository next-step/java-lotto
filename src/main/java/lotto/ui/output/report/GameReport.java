package lotto.ui.output.report;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.core.omr.Omr;
import lotto.core.omr.OmrCard;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.ui.output.Output;
import lotto.util.RateUtils;

public class GameReport {
    private static final double PROFIT_STANDARD = 1;

    private final double totalPrice;
    private final double totalWinningMoney;
    private final Map<Rank, List<Omr>> result;

    public GameReport(OmrCard omrCard, Round round) {
        this.result = omrCard.grade(round);
        this.totalPrice = calcTotalPrice(omrCard);
        this.totalWinningMoney = calcTotalWinningMoney();
    }

    public String rankFormat(Rank rank) {
        int size = totalSize(rank);
        String bonusMessage = bonusMessage(rank);

        return String.format("%d개 일치%s(%d원)- %d개", rank.countOfMatch(), bonusMessage, rank.winningMoney(), size);
    }

    public double yields() {
        return RateUtils.getRate(totalPrice, totalWinningMoney);
    }

    private int totalSize(Rank rank) {
        if (rank.isDuplicateMatch()) {
            return duplicateMatchSize();
        }

        return size(rank);
    }

    private int duplicateMatchSize() {
        Rank[] ranks = Rank.duplicateMatchValues();

        return Arrays.stream(ranks)
            .mapToInt(rank-> size(rank))
            .sum();
    }

    private int size(Rank rank) {
        return Optional.ofNullable(result.get(rank))
            .orElse(Collections.EMPTY_LIST)
            .size();
    }

    private String bonusMessage(Rank rank) {
        if (rank.isDuplicateMatch()) {
            return ", 보너스 볼 일치";
        }

        return " ";
    }

    private double calcTotalPrice(OmrCard omrCard) {
        return omrCard.size() * OmrCard.PRICE;
    }

    private double calcTotalWinningMoney() {
        return result.keySet().stream()
                    .mapToInt(key->result.get(key).size() * key.winningMoney())
                    .sum();
    }

    public void print(Output output) {
        output.println("당첨 통계");
        output.println("---------");
        output.println(statisticsToString(x-> rankFormat(x), Rank.winningValues()));
        output.println(yieldsToString(yields()));
    }

    private String statisticsToString(Function<Rank, String> function, Rank ...ranks) {
        return Arrays.stream(ranks)
            .map(rank->function.apply(rank))
            .collect(Collectors.joining("\n"));
    }

    private String yieldsToString(double yields) {
        String damageMessage = (yields < PROFIT_STANDARD) ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";

        return String.format("총 수익률은 %.2f입니다.%s", yields, damageMessage);
    }
}
