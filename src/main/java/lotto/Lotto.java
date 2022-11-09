package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumbers> lottoNumbers;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<LottoResult> match(WinningLotto winingLotto) {
        List<LottoResult> result = new ArrayList<>();
        for (LottoNumbers ticket : lottoNumbers) {
            result.add(winingLotto.match(ticket));
        }
        return result;
    }
}
