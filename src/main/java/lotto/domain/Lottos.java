package lotto.domain;

import lotto.util.TotalNumbers;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.util.Price.LOTTO_PRICE;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(Amount amount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < amount.lottoCount(); i++) {
            Collections.shuffle(TotalNumbers.NUMBERS);
            result.add(new Lotto(TotalNumbers.NUMBERS.subList(0, 6)
                            .stream()
                            .sorted(Comparator.comparingInt(Number::value))
                            .collect(Collectors.toList())
            ));
        }
        return new Lottos(result);
    }

    public List<Lotto> values() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Rank> getRanks(Lotto winningNumbers, Number bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public float calculateROI(List<Rank> ranks) {
        return (float) totalWinningMoney(ranks) / totalPayment();
    }

    private long totalWinningMoney(List<Rank> ranks) {
        return ranks.stream()
            .mapToInt(Rank::winningMoney)
            .sum();
    }

    private long totalPayment() {
        return (long) lottos.size() * LOTTO_PRICE;
    }

    public boolean isAllValidRange() {
        return lottos.stream().allMatch(Lotto::isValidRange);
    }

    public boolean isAllSorted() {
        return lottos.stream().allMatch(Lotto::isSorted);
    }
}
