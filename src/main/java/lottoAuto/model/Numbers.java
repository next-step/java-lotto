package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }
}
