package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final String WRONG_NUMBER_SIZE_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String WRONG_NUMBER_RANGE_MESSAGE = "1 ~ 45 범위가 벗어난 값이 존재합니다.";
    private static final String WRONG_INPUT_MESSAGE = "숫자, 공백 및 , 만 사용 가능합니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "중복된 번호가 있습니다.";
    private static final String DELIMITER = ",";
    private static final String OPERATOR_PATTERN_REGEX = "^[\\d,\\s]*$";
    private static final int ZERO_COUNT = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final Pattern operatorPattern = Pattern.compile(OPERATOR_PATTERN_REGEX);

    private final List<Integer> lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(toList(lottoNumber));
    }

    public LottoNumber(List<Integer> lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(List<Integer> lottoNumber) {
        for (Integer integer : lottoNumber) {
            if (integer < FIRST_LOTTO_NUMBER || integer > LAST_LOTTO_NUMBER) {
                throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MESSAGE);
            }
        }
        if (lottoNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_NUMBER_SIZE_MESSAGE);
        }
        HashSet<Integer> lottoNumberSet = new HashSet<>(lottoNumber);
        if (lottoNumberSet.size() < lottoNumber.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private static List<Integer> toList(String lottoNumber) {
        validate(lottoNumber);
        return Arrays.stream(split(lottoNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validate(String lottoNumber) {
        if (!operatorPattern.matcher(replace(lottoNumber)).matches()) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    private static String replace(String lottoNumber) {
        return lottoNumber.replace(" ", "");
    }

    private static String[] split(String lottoNumber) {
        return lottoNumber.trim()
                .split(DELIMITER);
    }

    public boolean isSize(int size) {
        return size == 6;
    }

    public Rank getRank(LottoNumber lottoNumber1) {
        return Rank.valueOf(getMatchCount(lottoNumber1));
    }

    private int getMatchCount(LottoNumber lottoNumber1) {
        int countOfMatch = ZERO_COUNT;
        for (int number : lottoNumber1.getLottoNumber()) {
            if (lottoNumber.contains(number)){
                countOfMatch++;
            }
        }
        return countOfMatch;
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
