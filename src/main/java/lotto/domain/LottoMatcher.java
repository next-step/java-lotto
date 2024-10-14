package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoMatcher {
    List<List<Integer>> matchLottoList = new ArrayList<>();
    private final List<Integer> lottoNumber;
    private final Lotto lotto;

    public LottoMatcher(Lotto lotto) {
        this.lotto = lotto;
        this.lottoNumber = lotto.getLottoNumber();
    }

    public List<Integer> matchLottoNumber(List<List<Integer>> userLottoList) {
        List<List<Integer>> matchLottoNumber;
        List<Integer> countMatchingNumbers = new ArrayList<>();
        for(int i = 0; i < userLottoList.size(); i++) {
            matchLottoNumber = findMatchLottoNumber(userLottoList, i);
            countMatchingNumbers.add(matchLottoNumber.get(i).size());
        }
        return countMatchingNumbers;
    }

    private List<List<Integer>> findMatchLottoNumber(List<List<Integer>> userLottoList, int purchasedLottoCount) {
        List<Integer> matchLottoNumberCount = new ArrayList<>();
        for(int j = 0; j < userLottoList.get(purchasedLottoCount).size(); j++) {
            matchLottoNumberCount = userLottoList.get(purchasedLottoCount).stream()
                                        .filter(number ->  lottoNumber.stream()
                                                .anyMatch(Predicate.isEqual(number)))
                                        .collect(Collectors.toList());
        }
        matchLottoList.add(matchLottoNumberCount);
        return matchLottoList;
    }

    @Override
    public String toString() {
        return "LottoMatcher{" +
                "matchLottoList=" + matchLottoList +
                '}';
    }
}
