package lotto.model;

import lotto.LottoConstants;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private List<Lotto> userLottos;
    private WinningLotto winningLotto;

    public Statistics(List<Lotto> userLottos, WinningLotto winningLotto) {
        this.userLottos = userLottos;
        this.winningLotto = winningLotto;
    }

    public Double getReturnsOfInvestment() {
        return toFixed(calculateReturnsOfInvestment(getTotalPrizePrice(getCountOfRank())));
    }

    public Map<Rank, Integer> getCountOfRank() {
        Map<Rank, Integer> result = initCountOfRank();
        for (Lotto userLotto : userLottos) {
            result.merge(winningLotto.getRank(userLotto), 1, Integer::sum);
        }
        return result;
    }

    private Map<Rank, Integer> initCountOfRank() {
        Map<Rank, Integer> countOfRank = new HashMap<>();
        Arrays.asList(Rank.values()).stream()
                .forEach(rank -> countOfRank.put(rank, 0));
        return countOfRank;
    }

    private int getTotalPrizePrice(Map<Rank, Integer> countOfRank) {
        return countOfRank.entrySet().stream()
                .mapToInt(mapper -> mapper.getKey().getWinningMoney() * mapper.getValue())
                .sum();
    }

    private double calculateReturnsOfInvestment(int totalPrizePrice) {
        return (double) totalPrizePrice / (userLottos.size() * LottoConstants.PRICE_PER_ONE);
    }

    private Double toFixed(double value) {
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        return Double.parseDouble(decimalFormat.format(value));
    }
}
