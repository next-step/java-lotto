package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }
}
