package lotto;

import lotto.domain.MyLottos;
import lotto.domain.MyPurchase;
import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        //로또 구입 금액 투입
        int money = InputView.money();
        MyPurchase myPurchase = new MyPurchase(money);
        ResultView.showLottoCount(myPurchase);

        //로또 자동 생성
        MyLottos myLottos = lottoService.buyAutoLottos(myPurchase);
        ResultView.showMyLottos(myLottos);

        //지난주 당첨 번호
        List<Integer> winNumbers = InputView.winLottoNumbers();
        Integer winBonusNumber = InputView.winLottoBonusNumber();
        WinLotto winLotto = lottoService.makeWinLotto(winNumbers, winBonusNumber);
        ResultView.showWinLotto(winLotto);

        //당첨번호 조회 및 통계
        lottoService.checkWin(myLottos, winLotto);
        ResultView.showLottoResult(myLottos.result());

        //수익률
        ResultView.showProfit(myLottos.profit());
    }
}
