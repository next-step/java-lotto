package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_CONDITION = 6;
    private static final String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또는 6개의 숫자입니다";

    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_CONDITION) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
