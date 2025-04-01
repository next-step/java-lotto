package step2.domain.lotto;

import java.util.*;

public class LottoRule {

    private final int minNumber;
    private final int maxNumber;
    private final int size;

    public LottoRule(int minNumber, int maxNumber, int size) {
        if (!isValid(minNumber, maxNumber, size)) {
            throw new IllegalArgumentException("invalid range");
        }
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.size = size;
    }

    public boolean isSatisfied(List<Integer> lottoNumbers) {
        if (containsOutOfRangeNumber(lottoNumbers)) return false;
        if (hasDuplicated(lottoNumbers)) return false;

        return hasCorrectSize(lottoNumbers);
    }

    private boolean hasCorrectSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == size;
    }

    private boolean hasDuplicated(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        return numberSet.size() != lottoNumbers.size();
    }

    private boolean containsOutOfRangeNumber(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < minNumber || maxNumber < number) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = minNumber; i <= maxNumber; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        List<Integer> generatedLotto = lottoNumbers.subList(0, size);
        generatedLotto.sort(Integer::compareTo);
        return generatedLotto;
    }

    private boolean isValid(int minNumber, int maxNumber, int size) {
        return minNumber <= maxNumber && size >= 1;
    }
}
