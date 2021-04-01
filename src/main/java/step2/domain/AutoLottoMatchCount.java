package step2.domain;

import java.util.HashMap;

public class AutoLottoMatchCount {
    HashMap<Integer, Integer> lottoMatchCount;

    public AutoLottoMatchCount() {
        this.lottoMatchCount = new HashMap<>();
        initLottoMatchCount();
    }

    public HashMap<Integer, Integer> getLottoMatchCount() {
        return lottoMatchCount;
    }

    private void initLottoMatchCount() {
        this.lottoMatchCount.put(3, 0);
        this.lottoMatchCount.put(4, 0);
        this.lottoMatchCount.put(5, 0);
        this.lottoMatchCount.put(6, 0);
    }

    public void lottoCountPlus(Integer number) {
        if (number > 2) {
            lottoMatchCount.put(number, lottoMatchCount.get(number) + 1);
        }
    }

    public int findLottoNumberCount(Integer number){
        return this.lottoMatchCount.get(number);
    }
}
