package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    public static List<Integer> lotto_number_list = new ArrayList<>();

    static {
        for (int i = LottoConstants.LOTTO_MIN_NUM; i <= LottoConstants.LOTTO_MAX_NUM; i++) {
            lotto_number_list.add(i);
        }
    }


}
