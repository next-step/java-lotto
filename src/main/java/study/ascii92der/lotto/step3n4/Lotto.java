package study.ascii92der.lotto.step3n4;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_VALID_COUNT = 6;
    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;

    public static final String ERROR_MASSAGE_WRONG_NUMBER_COUNT = "Lotto Number count is wrong";
    public static final String ERROR_MASSAGE_DUPLICATE_NUMBER = "This Numbers has duplicate number";
    public static final String ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER = "out of range Lotto number";

    private final List<Integer> lottoNumbers;

    public Lotto(String lottoString) {
        lottoNumbers = new ArrayList<>();
        String[] lottoArray = parseLottoString(lottoString);
        validNumberCount(lottoArray);
        validDuplicateNumber(lottoArray);

        for (String value : lottoArray) {
            lottoNumbers.add(validRangeNumber(value));
        }
    }

    private int validRangeNumber(String number) {
        int lottoNumber = Integer.parseInt(number);
        if (!(lottoNumber >= LOTTO_NUMBER_MINIMUM && LOTTO_NUMBER_MAXIMUM >= lottoNumber)) {
            throw new IllegalArgumentException(ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER);
        }
        return lottoNumber;
    }

    private void validNumberCount(String[] lottoArray) {
        if (lottoArray.length != LOTTO_NUMBER_VALID_COUNT) {
            throw new IllegalArgumentException(ERROR_MASSAGE_WRONG_NUMBER_COUNT);
        }
    }

    private void validDuplicateNumber(String[] lottoArray) {
        Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(lottoArray));
        if (lottoNumberSet.size() != lottoArray.length) {
            throw new IllegalArgumentException(ERROR_MASSAGE_DUPLICATE_NUMBER);
        }
    }

    private String[] parseLottoString(String lottoString) {
        return lottoString.replaceAll("[\\[\\] ]", "")
                .split(",");
    }

    public boolean hasNumber(int value) {
        return lottoNumbers.contains(value);
    }
}
