package step02;

public class LottoWinner {
    private LottoNumbers winnerNumber;

    public LottoWinner(InputNumberRule inputNumberRule) throws Exception {
      this.winnerNumber = new LottoNumbers(inputNumberRule);
    }

}
