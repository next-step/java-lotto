package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int GAP_BETWEEN_NUMBER_AND_INDEX_OF_ALL_LOTTO_NUMBERS = 1;
    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = new ArrayList<>();

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    static {
        setUpAllLottoNumbers();
    }

    private static void setUpAllLottoNumbers() {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            ALL_LOTTO_NUMBERS.add(new LottoNumber(number));
        }
    }

    static LottoNumber valueOf(int number) {
        int numberIndex = number - GAP_BETWEEN_NUMBER_AND_INDEX_OF_ALL_LOTTO_NUMBERS;
        return ALL_LOTTO_NUMBERS.get(numberIndex);
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
}
