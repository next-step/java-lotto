package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    public static List<Integer> lottoNumberList = new ArrayList<>();

    static {
        for (int i = LottoConstants.LOTTO_MIN_NUM; i <= LottoConstants.LOTTO_MAX_NUM; i++) {
            lottoNumberList.add(i);
        }
    }
}
