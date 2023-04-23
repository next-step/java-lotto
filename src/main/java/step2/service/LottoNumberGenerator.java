package step2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final int LOTTO_END_NUMBER = 45;

    private final List<Integer> defaultLottoNumbers;

    public LottoNumberGenerator() {
        this.defaultLottoNumbers = new ArrayList<>();
        for (int num = 1; num <= LOTTO_END_NUMBER; num++) {
            this.defaultLottoNumbers.add(num);
        }
    }

    public List<Integer> generateLottoNumbers() {
        mixLottoNumbers();
        List<Integer> randomNumbers = getRandomNumbers();
        Collections.sort(randomNumbers);
        return Collections.unmodifiableList(randomNumbers);
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> extractedNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            extractedNumbers.add(defaultLottoNumbers.get(i));
        }
        return extractedNumbers;
    }

    private void mixLottoNumbers() {
        Collections.shuffle(defaultLottoNumbers);
    }
}
