package lotto;

public class LottoMachine {

    private final LottoView lottoView;
    private final LottoNumbers lottoNumbers;

    public LottoMachine(LottoView lottoView, int lottoCount) {
        this.lottoView = lottoView;
        this.lottoNumbers = new LottoNumbers(lottoCount);

        lottoView.showLottoNumbers(lottoNumbers);
    }

    public void checkWinningLottoNumber(LottoNumber winningNumber) {
        lottoView.showLottoRanks(lottoNumbers.getRanks(winningNumber));
    }
}
