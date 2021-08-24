package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoList;

    public LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoGroup purchaseAutoLotto(LottoStrategy lottoStrategy, int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        while (lottoCount-- > 0) {
            lottoList.add(new Lotto(lottoStrategy.getNumbers()));
        }

        return new LottoGroup(lottoList);
    }

    public static LottoGroup purchaseManualLotto(List<Lotto> manualLottoList) {
        return new LottoGroup(manualLottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public List<List<Integer>> getLottoResult() {
        List<List<Integer>> result = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            result.add(lotto.getLottoNumbers());
        }

        return result;
    }

    public int size() {
        return lottoList.size();
    }

    public static LottoGroup combineGroup(LottoGroup manualLottoGroup, LottoGroup autoLottoGroup) {
        List<Lotto> allLottoList = new ArrayList<>();
        allLottoList.addAll(autoLottoGroup.getLottoList());
        allLottoList.addAll(manualLottoGroup.getLottoList());
        return new LottoGroup(allLottoList);
    }
}
