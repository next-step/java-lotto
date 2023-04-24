package step2.service;

import step2.util.ElectLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixedLottoNumbers {

    private static final int LOTTO_START_NUMBER = 1;

    private static final int LOTTO_END_NUMBER = 45;

    private final List<Integer> fixedLottoNumbers;

    public FixedLottoNumbers() {
        this.fixedLottoNumbers = new ArrayList<>();
        for (int num = LOTTO_START_NUMBER; num <= LOTTO_END_NUMBER; num++) {
            this.fixedLottoNumbers.add(num);
        }
    }

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(fixedLottoNumbers);
        return ElectLottoNumbers.electLottoNumbers(fixedLottoNumbers);
    }
}
