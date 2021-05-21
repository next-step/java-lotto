package step3.model;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<LottoNumbers> totalLotto() {
        return totalLotto;
    }

    public List<List<Integer>> lotto() {
        List<List<Integer>> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : totalLotto) {
            result.add(lottoNumbers.numbers());
        }
        return result;
    }

}
