package lotto;

import lotto.domain.MyLottos;
import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        //로또 구매 & 로또 자동 생성
        int money = InputView.buy();
        MyLottos myLottos = lottoService.autoGenerate(money);
        ResultView.showMyLottos(myLottos);

        //지난주 당첨 번호
        List<Integer> winLottoInfoNumbers = InputView.inputWinLottoNumbers();
        WinLotto winLotto = lottoService.makeWinLotto(winLottoInfoNumbers);
        ResultView.showWinLotto(winLotto);

        //당첨번호 조회 및 통계
        lottoService.checkWin(myLottos, winLotto);
        ResultView.showLottoResult(myLottos.result());

        //수익률
        ResultView.showProfit(myLottos.profit());
    }
}
