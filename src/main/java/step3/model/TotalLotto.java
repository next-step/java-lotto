package step3.model;

import java.util.ArrayList;

public class TotalLotto {

    private ArrayList<LottoNumbers> totalLotto;

    public TotalLotto() {
        totalLotto = new ArrayList<>();
    }

    public int size() {
        return totalLotto.size();
    }

    public void addLottoOne(LottoNumbers lottoNumbers) {
        totalLotto.add(lottoNumbers);
    }

}
