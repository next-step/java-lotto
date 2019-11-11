package lotto.domain;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_LENGTH_MIN = 1;
    private static final int LOTTO_LENGTH_MAX = 6;
    private static final String NUMBER_STRING_SEPARATOR = ", |,";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 숫자는 6개만 입력 가능합니다.";
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "중복 숫자는 허용하지 않습니다.";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers defaultNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers of(String numberString) {
        String[] numberStringArray = numberString.split(NUMBER_STRING_SEPARATOR);
        checkLottoLength(numberStringArray);
        List<LottoNumber> lottoNumbers = convertLottoNumbers(numberStringArray);
        checkDuplicated(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void checkLottoLength(String[] numberStringArray) {
        if (isOutOfRange(numberStringArray)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isOutOfRange(String[] numberStringArray) {
        return numberStringArray.length > LOTTO_LENGTH_MAX || numberStringArray.length < LOTTO_LENGTH_MIN;
    }

    private static List<LottoNumber> convertLottoNumbers(String[] numberStringArray) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String numberString : numberStringArray) {
            lottoNumbers.add(new LottoNumber(numberString));
        }

        return lottoNumbers;
    }

    private static void checkDuplicated(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> checkSet = new HashSet<>(lottoNumbers);
        if (checkSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers, new Random(System.currentTimeMillis()));
    }

    public LottoNumbers subList(int fromIndex, int toIndex) {
        return new LottoNumbers(new ArrayList<>(lottoNumbers.subList(fromIndex, toIndex)));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
