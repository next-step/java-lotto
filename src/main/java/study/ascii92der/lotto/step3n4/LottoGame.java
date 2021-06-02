package study.ascii92der.lotto.step3n4;

public class LottoGame {

    public void start(LottoPrice lottoPrice, Lotto winningLotto, LottoNumber lottoNumber) {

        ResultView.printLottoCount(lottoPrice);
        ResultView.printWinnerResult(
                new WinResult(
                        (new LottoGenerator()).generateLottos(lottoPrice),
                        new WinningLotto(winningLotto, lottoNumber)
                )
        );
    }
    
}
