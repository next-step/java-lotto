package lotto.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> NUMBER_MAP = new HashMap<>();
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String REGEX_NUMBER = "-?\\d+(\\.\\d+)?";
    private static final Pattern PATTERN_NUMBER = Pattern.compile(REGEX_NUMBER);

    private final int number;

    static {
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            NUMBER_MAP.put(i, new LottoNumber(i));//1~45로또 만들기
        }
    }

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateLottoNumber(number);
        return NUMBER_MAP.get(number);
    }

    public static LottoNumber from(String number) {
        validateLottoNumber(number);
        return NUMBER_MAP.get(Integer.parseInt(number));
    }

    public int getNumber() {
        return number;
    }

    private static void validateLottoNumber(int number) {
        if (number < 1 || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이입니다.");
        }
    }

    private static void validateLottoNumber(String number) {
        if (!PATTERN_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException("로또번호는 숫자입니다.");
        }
        validateLottoNumber(Integer.parseInt(number));
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
