package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVersionSix implements CreatableLotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    @Override
    public List<LottoNo> makeLotto() {
        List<LottoNo> list = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            list.add(new LottoNo(i));
        }
        return list;
    }
}
