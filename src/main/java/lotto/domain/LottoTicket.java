package lotto.domain;

public class LottoTicket {
    private final LottoNumber lottoTicket;

    LottoTicket(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoTicket = lottoNumberStrategy.get();
    }

    LottoTicket(LottoNumber lottoNumber) {
        this.lottoTicket = lottoNumber;
    }

    public LottoRank checkPrize(LottoNumber winningNumber) {
        int matchCount = (int) lottoTicket.getMatchCountInLottoNumber(winningNumber);
        return LottoRank.of(matchCount);
    }

    @Override
    public String toString() {
        return lottoTicket.getNumberToString();
    }
}
