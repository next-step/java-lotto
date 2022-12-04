package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String MISS_LOTTONUMBER_MATCH = "잘못된 로또 번호입니다.";
    private static final List<Integer> lottoNumbers =  new ArrayList<>();
    private final int number;

    static {
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER + 1; i++) {
            lottoNumbers.add(i);
        }
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(lottoNumbers.get(number));
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MISS_LOTTONUMBER_MATCH);
        }
    }

    public static List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
