package lotto.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;
    private static final int BEGIN_INDEX = 0;
    private static final String SEPARATOR = ", ";
    private static final int MATCH_COUNT_MIN = 3;
    private static final int MATCH_COUNT_MAX = 6;
    private static final int BEGIN_MATCH_COUNT = 1;

    public static int matchCount(LottoNumbers myLottoNumbers, LottoNumbers winningLottoNumbers) {
        List<LottoNumber> matchNumbers = myLottoNumbers.value2().stream()
                .filter(m -> winningLottoNumbers.value2().stream()
                        .anyMatch(Predicate.isEqual(m))).collect(Collectors.toList());
        return matchNumbers.size();
    }

    public static long reward(int matchCount) {
        return MatchType.of(matchCount).reward();
    }

    public static long lottoCount(long price) {
        return price / LOTTO_PRICE;
    }

    public static List<LottoNumbers> generateAllLottoNumbers(long lottoCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < lottoCount; i++) {
            lottoNumbersList.add(new LottoNumbers());
        }
        return lottoNumbersList;
    }

    public static LottoNumbers winningLottoNumbers(String input) {
        String[] split = input.split(SEPARATOR);
        Set<LottoNumber> numbers = new HashSet<>();

        for (int i = BEGIN_INDEX; i < split.length; i++) {
            numbers.add(new LottoNumber(Integer.parseInt(split[i])));
        }
        return new LottoNumbers(numbers);
    }

    public static double totalProfitRate(List<LottoNumbers> lottoNumbersList, LottoNumbers winningLottoNumbers) {
        long purchasePrice = lottoNumbersList.size() * LOTTO_PRICE;
        long totalReward = 0l;

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            if (isNotMatchCount(winningLottoNumbers, lottoNumbers)) {
                continue;
            }

            totalReward += MatchType.of(matchCount(lottoNumbers, winningLottoNumbers)).reward();
        }
        return totalReward / (double) purchasePrice;
    }

    public static double totalProfitRate2(Set<LottoNumbers> lottoNumbersSet, LottoNumbers winningLottoNumbers) {
        long purchasePrice = lottoNumbersSet.size() * LOTTO_PRICE;
        long totalReward = 0l;

        for (LottoNumbers lottoNumbers : lottoNumbersSet) {
            if (isNotMatchCount(winningLottoNumbers, lottoNumbers)) {
                continue;
            }

            totalReward += MatchType.of(matchCount(lottoNumbers, winningLottoNumbers)).reward();
        }
        return totalReward / (double) purchasePrice;
    }

    private static boolean isNotMatchCount(LottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
        return matchCount(lottoNumbers, winningLottoNumbers) < MATCH_COUNT_MIN || matchCount(lottoNumbers, winningLottoNumbers) > MATCH_COUNT_MAX;
    }

    public static Map<Integer, Integer> matchCounts(List<LottoNumbers> lottoNumbersList, LottoNumbers winningLottoNumbers) {
        Map<Integer, Integer> matchCounts = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            if (isNotMatchCount(winningLottoNumbers, lottoNumbers)) {
                continue;
            }

            if (!matchCounts.containsKey(matchCount(lottoNumbers, winningLottoNumbers))) {
                matchCounts.put(matchCount(lottoNumbers, winningLottoNumbers), BEGIN_MATCH_COUNT);
                continue;
            }
            int matchCount = matchCounts.get(matchCount(lottoNumbers, winningLottoNumbers));
            matchCounts.put(matchCount(lottoNumbers, winningLottoNumbers), matchCount + 1);
        }

        return matchCounts;
    }

    public static Map<Integer, Integer> matchCounts(Set<LottoNumbers> lottoNumbersList, LottoNumbers winningLottoNumbers) {
        Map<Integer, Integer> matchCounts = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            if (isNotMatchCount(winningLottoNumbers, lottoNumbers)) {
                continue;
            }

            if (!matchCounts.containsKey(matchCount(lottoNumbers, winningLottoNumbers))) {
                matchCounts.put(matchCount(lottoNumbers, winningLottoNumbers), BEGIN_MATCH_COUNT);
                continue;
            }
            int matchCount = matchCounts.get(matchCount(lottoNumbers, winningLottoNumbers));
            matchCounts.put(matchCount(lottoNumbers, winningLottoNumbers), matchCount + 1);
        }

        return matchCounts;
    }
}
