package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static Integer CANDIDATE_LOTTO_NUMBER_SIZE = 45;
    public static Integer CORRECT_LOTTO_NUMBERS_SIZE = 6;
    private static Integer MAX_LOTTO_NUMBER_VALUE= 45;
    private static Integer MINIMUM_LOTTO_NUMBER_VALUE= 1;
    private static final String NOT_CORRECT_LOTTO_NUMBERS_MESSAGE = "로또번호는 총 6개여야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBERS_MESSAGE = "로또번호는 중복이 있을 수 없습니다.";
    private static final String NOT_VALIDATE_NUMBER_RANGE_MESSAGE = "로또번호는 1~45 사이의 숫자입니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber < MINIMUM_LOTTO_NUMBER_VALUE || lottoNumber > MAX_LOTTO_NUMBER_VALUE)) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER_RANGE_MESSAGE);

        }
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_MESSAGE);
        }
        if (lottoNumbers.size() != CORRECT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBERS_MESSAGE);
        }
    }
}
