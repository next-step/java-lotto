package step2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultLottoNumber implements LottoNumber {

    private static final int LOTTO_END_NUMBER = 45;

    private final List<Integer> defaultLottoNumbers;

    public DefaultLottoNumber() {
        this.defaultLottoNumbers = new ArrayList<>();
        for (int num = 1; num <= LOTTO_END_NUMBER; num++) {
            this.defaultLottoNumbers.add(num);
        }
    }

    public List<Integer> extractLottoNumbers() {
        mixLottoNumbers();
        List<Integer> extractedNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            extractedNumbers.add(defaultLottoNumbers.get(i));
        }
        return Collections.unmodifiableList(extractedNumbers);
    }

    private void mixLottoNumbers() {
        Collections.shuffle(defaultLottoNumbers);
    }
}
