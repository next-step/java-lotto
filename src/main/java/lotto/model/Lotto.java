package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final String LOTTO_NUMBER_ALLOWED_BETWEEN_6_TO_45_INTEGER = "로또번호는 6~45 사이의 정수값만 허용됩니다.";
    public static final String LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED = "로또번호목록은 중복될수 없습니다.";
    public static final String LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6 = "로또번호목록은 반드시 6개의 로또번호를 입력해야 합니다..(6,7,17,28,39,45)";
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> lottoNumbers;

    private Lotto(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(final int... lottoNumbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int lottoNumber : lottoNumbers) {
            validateLottoNumber(lottoNumber);
            result.add(lottoNumber);
        }
        validateLottoNumbers(result);
        return new Lotto(result);
    }

    private static void validateLottoNumbers(ArrayList<Integer> result) {
        int lottoNumbersSize = result.size();

        int distinctLottoNumbersSize = new HashSet<>(result).size();
        if (distinctLottoNumbersSize < lottoNumbersSize) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
        }

        if (lottoNumbersSize != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
        }
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER ||
                lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ALLOWED_BETWEEN_6_TO_45_INTEGER);
        }
    }
}
