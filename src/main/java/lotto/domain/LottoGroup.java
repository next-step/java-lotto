package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private final List<LottoNumbers> lottoNumbersGroup;

    public LottoGroup() {
        lottoNumbersGroup = new ArrayList<>();
    }

    public void add(LottoNumbers lottoNumbers) {
        lottoNumbersGroup.add(lottoNumbers);
    }

    public List<LottoNumbers> getNumbers() {
        return lottoNumbersGroup;
    }

    public int getLottoNumbersCount() {
        return lottoNumbersGroup.size();
    }
}
