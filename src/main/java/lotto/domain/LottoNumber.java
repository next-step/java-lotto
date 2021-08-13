package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String INVALID_WINNING_NUMBERS = "유효하지 않은 번호를 입력하셨습니다.";
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 46;

    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    private final int number;

    static {
        for (int number = MIN_RANGE; number < MAX_RANGE; number++) {
            lottoNumberMap.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        validateNumber(lottoNumber);
        return lottoNumberMap.get(lottoNumber);
    }

    public static LottoNumber valueOf(String strLottoNumber) {
        return valueOf(Integer.parseInt(strLottoNumber.trim()));
    }

    private static void validateNumber(int number) {
        if (number > MAX_RANGE || number < MIN_RANGE) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS);
        }
    }

    private int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber n) {
        return this.number - n.getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(getNumber());
    }
}