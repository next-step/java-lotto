package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int compareLottoAndWinnerNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isContain).count()).intValue();
    }

    public int compareLottoAndBonusNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isEqualBonusNumber).count()).intValue();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
