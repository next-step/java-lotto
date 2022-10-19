package lotto.core;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_SIZE = 6;
    public static final int LOTTO_BOUND_NUM = 46;

    private final List<Integer> lottoNums;

    public Lotto() {
        Random random = new Random();
        Set<Integer> tmpLottoNums = new HashSet<>();
        while (tmpLottoNums.size() < MAX_SIZE) {
            int lottoNum = random.nextInt(LOTTO_BOUND_NUM);
            tmpLottoNums.add(lottoNum);
        }
        lottoNums = new ArrayList<>(tmpLottoNums);
        Collections.sort(lottoNums);
    }

    public Lotto(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return "" + lottoNums;
    }

    public int getCorrectCount(WinningNumbers winningNumbers){
        List<Integer> winningNumbersToCompare = winningNumbers.getWinningNumbers();
        List<Integer> result = lottoNums.stream()
                .filter(old -> winningNumbersToCompare.stream().anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
        return result.size();
    }
}
