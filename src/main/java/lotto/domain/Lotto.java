package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int matchCount(LottoNumbers luckyNumbers) {
        return lottoNumbers.matchCount(luckyNumbers);
    }

    public WinningType getPrize(LottoNumbers luckyNumbers) {
        return WinningType.findByMatchCount(matchCount(luckyNumbers));
    }

    public WinningType getRank(LottoNumbers luckyNumbers) {
        return WinningType.findByMatchCount(matchCount(luckyNumbers));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
