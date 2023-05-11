package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        //로또 구입 금액 투입
        int money = InputView.money();
        MyPurchase myPurchase = new MyPurchase(money);
        ResultView.showLottoCount(myPurchase);

        //로또 자동 생성
        MyLottoGame myLottoGame = MyLottoGame.autoGenerate(myPurchase);
        ResultView.showMyLottos(myLottoGame.getLottos());

        //지난주 당첨 번호
        List<Integer> winNumbers = InputView.winLottoNumbers();
        Integer winBonusNumber = InputView.winLottoBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, winBonusNumber);
        ResultView.showWinLotto(winLotto);

        //당첨번호 조회 및 통계, 수익률
        MyResult myResult = myLottoGame.checkWin(winLotto);
        ResultView.showLottoResult(myResult);
    }
}
