package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int numOfSize() {
        return -1;
    }
}
