package lotto.domain;

public class Lotto {
    private static final int CHECK_LOTTO_MATCH_COUNT = 5;
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    int size() {
        return lottoNumbers.size();
    }

    public int matchCount(LottoNumbers luckyNumbers) {
        return lottoNumbers.matchCount(luckyNumbers);
    }

    public WinningType getPrize(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        return WinningType.findByMatchCountAndMatchBonus(matchCount(luckyNumbers), isCheckMatchBonus(luckyNumbers, bonusNumber));
    }

    public WinningType getRank(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        return WinningType.findByMatchCountAndMatchBonus(matchCount(luckyNumbers), isCheckMatchBonus(luckyNumbers, bonusNumber));
    }

    public boolean isCheckMatchBonus(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        int matchCount = lottoNumbers.matchCount(luckyNumbers);
        if(matchCount == CHECK_LOTTO_MATCH_COUNT) {
            return lottoNumbers.isMatchBonus(bonusNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
