package lotto.domain;

public class LottoTicket {
    private final LottoNumber lottoTicket;

    LottoTicket(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoTicket = lottoNumberStrategy.get();
    }

    LottoTicket(LottoNumber lottoNumber) {
        this.lottoTicket = lottoNumber;
    }

    public LottoRank checkPrize(WinningNumber winningNumber) {
        int matchCount = (int) lottoTicket.getMatchCountInLottoNumber(winningNumber);
        if (isMatchFiveAndBonus(winningNumber, matchCount)) {
            return LottoRank.FIVE_BONUS;
        }
        return LottoRank.of(matchCount);
    }

    private boolean isMatchFiveAndBonus(WinningNumber winningNumber, int matchCount) {
        return matchCount == 5 && winningNumber.isMatchBonusNumber(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.getNumberToString();
    }
}
