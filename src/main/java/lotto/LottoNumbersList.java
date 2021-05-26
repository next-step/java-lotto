package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    public LottoNumbersList() {
        lottoNumbersList = new ArrayList<LottoNumbers>();
    }

    public void appendLottoNumber(LottoNumbers numbers) {
        lottoNumbersList.add(numbers);
    }

    public int count() {
        return lottoNumbersList.size();
    }

    public void foreach() {
        lottoNumbersList.forEach(new Consumer<LottoNumbers>() {
            @Override
            public void accept(LottoNumbers lottoNumbers) {
                System.out.println(lottoNumbers.getLottoNumbers());
            }
        });
    }

    public ResultAll countMatchedNumbersList(LastWonLottoNumber lastWonLottoNumber) {
        ResultAll resultAll = new ResultAll();
        SameNumberCountInALotto sameNumberCountInALotto = null;
        for (int i = 0; i < lottoNumbersList.size(); i++) {
            sameNumberCountInALotto = lottoNumbersList.get(i).countMatchedNumbers(lastWonLottoNumber);
            resultAll.updateResult(sameNumberCountInALotto);
        }
        return resultAll;
    }
}
