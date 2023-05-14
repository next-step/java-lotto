package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        //로또 구입 금액 / 수동 구매 로또 수
        int money = InputView.money();
        int manualCount = InputView.manualCount();
        MyPurchase myPurchase = new MyPurchase(money, manualCount);
        List<LottoNumbers> manualLottos = InputView.manualNumbers(manualCount);
        ResultView.showLottoCount(myPurchase);

        //로또 생성
        MyLottoGame myLottoGame = MyLottoGame.generate(myPurchase, manualLottos);
        ResultView.showMyLottos(myLottoGame.getLottos());

        //지난주 당첨 번호
        List<LottoNo> winNumbers = InputView.winLottoNumbers();
        LottoNo winBonusNumber = InputView.winLottoBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, winBonusNumber);
        ResultView.showWinLotto(winLotto);

        //당첨번호 조회 및 통계, 수익률
        MyResult myResult = myLottoGame.checkWin(winLotto);
        ResultView.showLottoResult(myResult);
    }
}
