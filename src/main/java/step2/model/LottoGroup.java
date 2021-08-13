package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    public LottoGroup(int lottoCount) {
        lottoList = new ArrayList<>();

        while (lottoCount-- > 0) {
            lottoList.add(new Lotto(new AutoLottoStrategy()));
        }
    }

    public List<List<Integer>> getLottoResult() {
        List<List<Integer>> result = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            result.add(lotto.getLottoNumbers());
        }

        return result;
    }
}
