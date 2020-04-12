package lotto.vo;

import lotto.domain.object.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoList {

    private final List<Lotto> lottoList;

    public LottoList(final int purchaseCount) {
        lottoList = new ArrayList<Lotto>(Arrays.asList(new Lotto[purchaseCount]));
    }

    public int getCount() {
        return lottoList.size();
    }
}
