package step2.model;

import step2.enumeration.LottoRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinner {

    private Map<Integer, Long> winnerNumber;
    private final List<Lotto> lottos;

    public LottoWinner(List<Lotto> lottos) {
        winnerNumber = new HashMap<>();
        this.lottos = lottos;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int match : this.winnerNumber.keySet()) {
            totalPrice += LottoRank.getPriceByMatch(match);
        }

        return totalPrice;
    }

    public Map<Integer, Long> getWinnerScore(String winnerNumbers) {
        List<Integer> winNumbers = splitWinNumberString(winnerNumbers);
        this.winnerNumber = this.lottos.stream()
                .map(lotto -> lotto.getLottoWinner(winNumbers))
                .filter(score -> score >= 3)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return this.winnerNumber;
    }

    public Double getRating(int payPrice) {
        int totalPrice = getTotalPrice();
        return Math.floor(totalPrice * 100.0 / payPrice) / 100;
    }

    private List<Integer> splitWinNumberString(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
