package lotto;

public class LottoTicket {

    private LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public long drawing(LottoNumbers winningNumbers) {
        return lottoNumbers.matchNumbers(winningNumbers);
    }
}
