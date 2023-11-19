package step3.model;

import step3.enumeration.LottoRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static step3.enumeration.LottoRank.SECOND;

public class LottoWinner {

    private static final int MINIMUM_WIN_COUNT = 3;
    private Map<Integer, Long> winnerNumberCount;
    private final List<Lotto> lottos;
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoWinner(List<Lotto> lottos, String winNumber, int bonusNumber) {
        winnerNumberCount = new HashMap<>();
        this.lottos = lottos;
        this.winNumbers = splitWinNumberString(winNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int match : this.winnerNumberCount.keySet()) {
            totalPrice += LottoRank.getPriceByMatch(match);
        }

        return totalPrice;
    }

    public Map<Integer, Long> getWinnerNumberMatchCount() {
        this.winnerNumberCount = this.lottos.stream()
                .map(lotto -> lotto.getLottoWinner(this.winNumbers))
                .filter(score -> score >= MINIMUM_WIN_COUNT)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return this.winnerNumberCount;
    }

    public Map<Integer, Long> getBonusNumberMatchCount() {
        Map<Integer, Long> bonus = this.lottos.stream()
                .map(lotto -> lotto.getBonusNumberCount(this.winNumbers, this.bonusNumber))
                .filter(match -> match == SECOND.getMatch())
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        bonus.entrySet().stream().map(bonusNumber -> this.winnerNumberCount.put(bonusNumber.getKey(), bonusNumber.getValue()));
        return this.winnerNumberCount;
    }

    public Double getRating(int payPrice) {
        int totalPrice = getTotalPrice();
        return Math.floor(totalPrice * 100.0 / payPrice) / 100;
    }

    private List<Integer> splitWinNumberString(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(","))
                .map(Integer::parseInt)
                .filter(e -> !new LottoNumber().isOverMaxNumber(e))
                .collect(Collectors.toList());

    }
}
