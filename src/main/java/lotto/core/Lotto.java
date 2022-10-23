package lotto.core;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> lottoNums;

    public Lotto(LottoGenerateStrategy lottoGenerateStrategy) {
        lottoNums = lottoGenerateStrategy.generateLotto();
    }

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    public int getCorrectCount(WinningLottoNumbers winningLottoNumbers){
        List<Integer> winningNumbersToCompare = winningLottoNumbers.getWinningNumbers();
        List<Integer> result = lottoNums.stream()
                .filter(old -> winningNumbersToCompare.stream().anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
        return result.size();
    }
}
