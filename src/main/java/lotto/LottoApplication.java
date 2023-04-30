package lotto;

import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        //로또 구매
        InputView inputView = InputView.buy();
        LottoService lottoService = new LottoService(inputView.money());
        //로또 자동 생성
        lottoService.autoGenerate();
        ResultView.showMyLottos(lottoService.lottos());
        //지난주 당첨 번호
        WinLotto winLotto = new WinLotto(inputView.winLottoInfo());
        ResultView.showWinLotto(winLotto);
        //당첨번호 조회 및 통계
        lottoService.checkWin(winLotto);
        ResultView.showLottoResult(lottoService.result());
        //수익률
        ResultView.showProfit(lottoService.profit());
    }
}
