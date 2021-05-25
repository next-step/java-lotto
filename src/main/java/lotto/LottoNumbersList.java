package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;
    private ResultAll resultAll;

    public LottoNumbersList() {
        lottoNumbersList = new ArrayList<LottoNumbers>();
        resultAll = new ResultAll();
    }

    public void appendLottoNumber(LottoNumbers numbers) {
        lottoNumbersList.add(numbers);
    }

    public int count() {
        return lottoNumbersList.size();
    }

    public LottoNumbers get(int index) {
        return lottoNumbersList.get(index);
    }

    public void countMatchedNumbersList(LastWonLottoNumber lastWonLottoNumber) {
        SameNumberCountInALotto sameNumberCountInALotto = null;
        for (int i = 0; i < lottoNumbersList.size(); i++) {
            sameNumberCountInALotto = lottoNumbersList.get(i).countMatchedNumbers(lastWonLottoNumber);
            updateResultLotto(sameNumberCountInALotto);
        }
    }

    private void updateResultLotto(SameNumberCountInALotto sameNumberCountInALotto) {
        resultAll.updateResult(sameNumberCountInALotto);
    }

    public ResultAll getResultAll() {
        return resultAll;
    }
}
