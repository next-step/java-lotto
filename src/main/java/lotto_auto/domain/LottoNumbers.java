package lotto_auto.domain;

import lotto_auto.io.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbersList;

    public LottoNumbers(List<Integer> numberList) {
        this.lottoNumbersList = new ArrayList<>();
        this.lottoNumbersList.addAll(numberList);
    }

    public List<Integer> getLottoNumbersList() {
        return lottoNumbersList;
    }

    @Override
    public String toString() {
        return lottoNumbersList.toString();
    }
}
