package lotto;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lottos lottos = inputView.lottoBuyStart();
        LottoResult lottoResult = lottos.compareWinNumber(inputView.inputWinLottoNumber());

        ResultView resultView = new ResultView();
        resultView.prinfResult(lottoResult);
    }
}
