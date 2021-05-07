package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static Integer CANDIDATE_LOTTO_NUMBER_SIZE = 45;
    public static Integer CORRECT_LOTTO_NUMBERS_SIZE = 6;
    private static String NOT_CORRECT_LOTTO_NUMBERS_MESSAGE = "로또번호는 총 6개여야 합니다.";
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != CORRECT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBERS_MESSAGE);
        }
    }
}
