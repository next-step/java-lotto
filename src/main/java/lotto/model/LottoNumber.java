package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int GAP_BETWEEN_NUMBER_AND_INDEX_OF_ALL_LOTTO_NUMBERS = 1;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = new ArrayList<>();

    private int number;

    private LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    static {
        setUpAllLottoNumbers();
    }

    private static void setUpAllLottoNumbers() {
        for (int number = MIN; number <= MAX; number++) {
            ALL_LOTTO_NUMBERS.add(new LottoNumber(number));
        }
    }

    public static LottoNumber valueOf(int number) {
        validateRange(number);
        int numberIndex = number - GAP_BETWEEN_NUMBER_AND_INDEX_OF_ALL_LOTTO_NUMBERS;
        return ALL_LOTTO_NUMBERS.get(numberIndex);
    }

    private static void validateRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d이상 %d이하의 숫자이어야 합니다.", MIN, MAX));
        }
    }

    static List<LottoNumber> getAllLottoNumbers() {
        return new ArrayList<>(ALL_LOTTO_NUMBERS);
    }

    int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
