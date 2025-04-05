package domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int getHitCount(List<Integer> winNumbers) {
        return lottoNumbers.getHitCount(winNumbers);
    }

    public int getHitCount(LottoNumbers winNumbers) {
        return lottoNumbers.getHitCount(winNumbers);
    }

    public boolean hasBonusNumber(int bonus) {
        return lottoNumbers.hasBonusNumber(bonus);
    }

}
