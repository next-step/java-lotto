package lotto;

public class LottoTicket {

    private LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int drawing(LottoNumbers winningNumbers) {
        return lottoNumbers.matchNumbers(winningNumbers);
    }
}
