package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<List<Integer>> lottoNumbers;

    public Lotto(int count) {
        lottoNumbers = new HashSet<>();

        for (int i = 0; i < count; i++) {
            List<Integer> set = NumberGenerator.generateOneSet();
            lottoNumbers.add(set);
        }
    }

    public Lotto(Set<List<Integer>> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (List<Integer> oneSet : lottoNumbers) {
            String lottoNums = oneSet.stream().map(num -> Integer.toString(num)).collect(Collectors.joining(delimiter));
            stringBuilder.append(String.format(format, lottoNums));
        }

        return stringBuilder.toString();
    }

    public Map<Winning, Integer> getResult(List<Integer> winningNumber) {
        Map<Winning, Integer> result = new HashMap<>();

        for (List<Integer> oneSet : lottoNumbers) {
            long matchCount = winningNumber.stream().filter(oneSet::contains).count();
            Winning winning = Winning.getWinningType((int) matchCount);
            result.put(winning, result.containsKey(winning) ? result.get(winning) + 1 : 1);
        }

        return result;
    }

    public static String calculateYield(int paidMoney, int profit) {
        return String.format("%.2f", (float) profit/(float) paidMoney);
    }
}
