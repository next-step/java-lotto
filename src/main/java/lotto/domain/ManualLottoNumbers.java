package lotto.domain;

import java.util.Collections;
import java.util.List;

public class ManualLottoNumbers {

    private final List<LottoNumberText> lottoNumberTextList;

    public ManualLottoNumbers(List<LottoNumberText> lottoNumberTextList) {
        this.lottoNumberTextList = lottoNumberTextList;
    }

    public int count() {
        return lottoNumberTextList.size();
    }

    public List<LottoNumberText> toList() {
        return Collections.unmodifiableList(lottoNumberTextList);
    }
}
