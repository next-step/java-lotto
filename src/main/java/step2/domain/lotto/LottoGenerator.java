package step2.domain.lotto;

import java.util.*;

public class LottoGenerator {

    private final int size;
    private final List<Integer> lottoNumbers;

    public LottoGenerator(int minNumber, int maxNumber, int size) {
        if (!isValid(minNumber, maxNumber, size)) {
            throw new IllegalArgumentException("invalid range");
        }
        this.size = size;
        this.lottoNumbers = createNumberRange(minNumber, maxNumber);
    }

    public LottoNumbers generateLotto() {
        List<Integer> generatedRandomNumbers = generateRandomNumbers();
        Set<LottoNumber> generatedLottoNumbers = new HashSet<>();
        for (Integer number : generatedRandomNumbers) {
            generatedLottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumbers(generatedLottoNumbers);
    }

    private List<Integer> createNumberRange(int minNumber, int maxNumber) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = minNumber; i <= maxNumber; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, size);
    }

    private boolean isValid(int minNumber, int maxNumber, int size) {
        return minNumber <= maxNumber && size >= 1;
    }
}
