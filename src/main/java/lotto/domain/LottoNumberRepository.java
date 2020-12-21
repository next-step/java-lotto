package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberRepository {
    private static final int INITIAL_INDEX = 0;
    private static final int TOTAL_LENGTH = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> lottoNumber = new ArrayList<>();

    public LottoNumberRepository() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumber.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(lottoNumber);
        List<Integer> randomNumbers = lottoNumber.subList(INITIAL_INDEX, TOTAL_LENGTH);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
