package lotto.domain;

import java.util.ArrayList;
import java.util.List;

//1부터 45까지의 로또 번호
public class LottoNumberList {

    public static List<LottoNumber> lottoNumberList = new ArrayList<>();

    static {
        for (int i = LottoConstants.LOTTO_MIN_NUM; i <= LottoConstants.LOTTO_MAX_NUM; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
    }
}
