package lotto.domain;

import lotto.util.Prize;
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

    public Map<Integer, Integer> getMatchNums(Lotto winningNumbers) {
        Map<Integer, Integer> matchNums = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchNum = lotto.getMatchNum(winningNumbers);
            matchNums.put(matchNum, matchNums.getOrDefault(matchNum, 0) + 1);
        }
        return matchNums;
    }

    public float calculateROI(Map<Integer, Integer> matchNums) {
        if (lottos.isEmpty()) {
            return 0;
        }

        long result = 0;
        for (Prize prize : Prize.values()) {
            result += (long) prize.money() * matchNums.getOrDefault(prize.number(), 0);
        }

        return (float) result / (lottos.size() * LOTTO_PRICE);
    }

    public boolean isAllValidRange() {
        return lottos.stream().allMatch(Lotto::isValidRange);
    }

    public boolean isAllSorted() {
        return lottos.stream().allMatch(Lotto::isSorted);
    }
}
