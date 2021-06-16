package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private List<Integer> numbers = new ArrayList<>();

    public AutoLotto() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(numbers);

        List<Integer> selectedNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            selectedNumbers.add(numbers.get(i));
        }
        Collections.sort(selectedNumbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int selectedNumber : selectedNumbers) {
            lottoNumbers.add(LottoNumber.of(selectedNumber));
        }
        return lottoNumbers;
    }
}
