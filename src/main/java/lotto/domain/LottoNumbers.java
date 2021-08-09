package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers = new ArrayList<>();
    private static final int BOUND = 45;
    private static final int SIZE = 6;

    public LottoNumbers() {
        for (int i = 1; i <= BOUND; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> generateRandomNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            randomNumbers.add(lottoNumbers.get(i));
        }
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
