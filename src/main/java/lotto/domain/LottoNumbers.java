package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_LENGTH_MIN = 1;
    private static final int LOTTO_LENGTH_MAX = 6;
    private static final String NUMBER_STRING_SEPARATOR = ", |,";
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 숫자는 6개만 입력 가능합니다.";
    public static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "중복 숫자는 허용하지 않습니다.";
    private static final String TO_STRING_FORMAT = "[%s]";
    private static final String NUMBERS_JOIN_DELIMITER = ", ";
    private static final int HASH_CODE_PRIME = 59;

    private List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers defaultNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER; i++) {
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

    public static LottoNumbers of(int[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

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

    public LottoNumbers subNumbers(int fromIndex, int toIndex) {
        return new LottoNumbers(new ArrayList<>(lottoNumbers.subList(fromIndex, toIndex)));
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        String numberString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(NUMBERS_JOIN_DELIMITER));
        return String.format(TO_STRING_FORMAT, numberString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (LottoNumber lottoNumber : lottoNumbers) {
            hashCode = HASH_CODE_PRIME * hashCode + (lottoNumber == null ? 0 : lottoNumber.hashCode());
        }
        return hashCode;
    }
}
