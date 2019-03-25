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

    public int prize(LottoNumbers luckyNumbers) {
        return WinningType.getPrize(lottoNumbers.matchCount(luckyNumbers));
    }

    public int rank(LottoNumbers luckyNumbers) {
        return WinningType.getRank(lottoNumbers.matchCount(luckyNumbers));
    }

    @Override
    public String toString() {
        return lottoNumbers.printLottoNumbers();
    }
}
