package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AllLottoNumbers {

    private static final int BEGIN_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public static List<LottoNumber> value() {
        return initNumbers();
    }

    private static List<LottoNumber> initNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = BEGIN_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
