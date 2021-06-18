package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    public LottoNumbersList() {
        lottoNumbersList = new ArrayList<LottoNumbers>();
    }

    public LottoNumbersList(LottoNumbers[] lottoNumbersArray) {
        lottoNumbersList = new ArrayList<LottoNumbers>();
        for (LottoNumbers lottoNumbers : lottoNumbersArray)
            lottoNumbersList.add(lottoNumbers);
    }

    public void appendLottoNumber(LottoNumbers numbers) {
        lottoNumbersList.add(numbers);
    }

    public int count() {
        return lottoNumbersList.size();
    }

    public void foreach(Consumer<LottoNumbers> lottoNumbers) {
        lottoNumbersList.forEach(lottoNumbers);
    }

    public LottoNumbers lottoNumberList(int i) {
        return lottoNumbersList.get(i);
    }
}
