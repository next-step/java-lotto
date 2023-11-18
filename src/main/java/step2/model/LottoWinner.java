package step2.model;

import step2.enumeration.LottoRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinner {

    private static final int MINIMUM_WIN_COUNT = 3;
    private Map<Integer, Long> winnerNumberCount;
    private final List<Lotto> lottos;
    private final String winNumber;

    public LottoWinner(List<Lotto> lottos, String winNumber) {
        winnerNumberCount = new HashMap<>();
        this.lottos = lottos;
        this.winNumber = winNumber;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int match : this.winnerNumberCount.keySet()) {
            totalPrice += LottoRank.getPriceByMatch(match);
        }

        return totalPrice;
    }

    public Map<Integer, Long> getWinnerScore() {
        List<Integer> winNumbers = splitWinNumberString(this.winNumber);
        this.winnerNumberCount = this.lottos.stream()
                .map(lotto -> lotto.getLottoWinner(winNumbers))
                .filter(score -> score >= MINIMUM_WIN_COUNT)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

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
