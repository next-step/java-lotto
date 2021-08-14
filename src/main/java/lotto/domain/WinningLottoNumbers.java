package lotto.domain;

public class WinningLottoNumbers {

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusBall;

    private WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        this.winningLottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLottoNumbers of(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        return new WinningLottoNumbers(lottoNumbers, bonusBall);
    }

    public Rank match(LottoNumbers lottoNumbers) {
        int countOfMatch = winningLottoNumbers.countOfMatch(lottoNumbers);
        boolean hitBonusBall = lottoNumbers.contains(bonusBall);
        return Rank.valueOf(countOfMatch, hitBonusBall);
    }
}
