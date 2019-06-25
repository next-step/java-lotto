package step3.iksoo.lotto2rd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottoes {
    private List<Lotto> lottoes;

    Lottoes(List<Lotto> lottoList) {
        this.lottoes = lottoList;
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }

    public Map<Rank, Integer> checkLotteryWin(List<Integer> winnerNumbers, int bonusBall) {
        Map<Rank, Integer> matchResult = new HashMap<>();

        Rank[] ranks = Rank.values();
        Arrays.stream(ranks)
                .forEach(rank -> matchResult.put(rank, 0));

        this.lottoes
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers, bonusBall))
                .filter(rank -> rank.getCountOfMatch() >= 3)
                .forEach(rank -> matchResult.put(rank, matchResult.get(rank) + 1));

        return matchResult;
    }

    public double calculateRateProfit(int amoutPrize, int orderPrice) {
        return (double) amoutPrize / orderPrice;
    }
}