package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbersList_ref {
    private List<LottoNumbers_ref> lottoNumbersRefList;

    public LottoNumbersList_ref() {
        lottoNumbersRefList = new ArrayList<LottoNumbers_ref>();
    }

    public void appendLottoNumber(LottoNumbers_ref numbers) {
        lottoNumbersRefList.add(numbers);
    }

    public int count() {
        return lottoNumbersRefList.size();
    }

    public void foreach(Consumer<LottoNumbers_ref> lamda) {
        lottoNumbersRefList.forEach(lamda);
    }

    public ResultAllLottoScores_ref countMatchedNumbersList(LastWonLottoNumber_ref lastWonLottoNumberRef) {
        ResultAllLottoScores_ref resultAllLottoScoresRef = new ResultAllLottoScores_ref();
        MatchStatusOfALotto_ref matchStatusOfALotto_ref = null;
        for (int i = 0; i < lottoNumbersRefList.size(); i++) {
            matchStatusOfALotto_ref = lottoNumbersRefList.get(i).countMatchedNumbers(lastWonLottoNumberRef);
            resultAllLottoScoresRef.updateResult(matchStatusOfALotto_ref);
        }
        return resultAllLottoScoresRef;
    }
}
