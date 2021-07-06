package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(LottoNumber.of(i));
        }
    }

    public static Lotto createAutoLotto() {
        Collections.shuffle(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i< LOTTO_SIZE;i++) {
            lottoNumbers.add(numbers.get(i));
        }
        //Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto createManualLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
