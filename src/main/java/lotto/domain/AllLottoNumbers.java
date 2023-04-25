package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AllLottoNumbers {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static List<LottoNumber> value() {
        return initNumbers();
    }

    private static List<LottoNumber> initNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
