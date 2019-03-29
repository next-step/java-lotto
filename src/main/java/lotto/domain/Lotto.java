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

    public int matchCount(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.matchCount(lottoNumbers);
    }

    public WinningType getWinningType(WinningLottoNumbers winningLottoNumbers) {
        int matchCount = winningLottoNumbers.matchCount(lottoNumbers);
        return WinningType.findByMatchCountAndMatchBonus(matchCount, isCheckMatchBonus(matchCount, winningLottoNumbers));
    }

    public boolean isCheckMatchBonus(int matchCount, WinningLottoNumbers winningLottoNumbers) {
        if(matchCount == CHECK_LOTTO_MATCH_COUNT) {
            return lottoNumbers.isMatchBonus(winningLottoNumbers);
        }
        return false;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
