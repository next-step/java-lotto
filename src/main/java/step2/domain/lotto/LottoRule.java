package step2.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        for (int number : lottoNumbers) {
            if (number < minNumber || maxNumber < number) {
                return false;
            }
        }
        return lottoNumbers.size() == size;
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
