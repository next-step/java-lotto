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

    public static Lottos from(int inputPrice) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < inputPrice / LOTTO_PRICE; i++) {
            Collections.shuffle(TotalNumbers.NUMBERS);
            result.add(new Lotto(TotalNumbers.NUMBERS.subList(0, 6)
                            .stream()
                            .sorted(Comparator.comparingInt(Number::getValue))
                            .collect(Collectors.toList())
            ));
        }
        return new Lottos(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
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

    public boolean isAllValidRange() {
        return lottos.stream().allMatch(Lotto::isValidRange);
    }

    public boolean isAllSorted() {
        return lottos.stream().allMatch(Lotto::isSorted);
    }
}
