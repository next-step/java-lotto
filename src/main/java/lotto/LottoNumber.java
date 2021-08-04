package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    static final List<LottoNumber> ALL_LOTTO_NUMBERS = new ArrayList<>();

    static {
        setUpAllLottoNumbers();
    }

    private static void setUpAllLottoNumbers() {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            ALL_LOTTO_NUMBERS.add(new LottoNumber(number));
        }
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }
}
