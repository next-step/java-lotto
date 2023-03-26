package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        HitLotto hitLotto = new HitLotto();

        // 구입금액 입력
        long purchaseAmount = inputView.purchaseAmount();

        // 로또 생성
        Lotto lotto = new Lotto(purchaseAmount, hitLotto.getLotto(hitLotto.getPurchaseCount(purchaseAmount)));

        // 구매내역 출력
        resultView.purchaseHistory(hitLotto.getPurchaseCount(purchaseAmount), lotto);

        // 지난 주 당첨 번호 입력
        String stringWinningNumbers = inputView.inputWinningNumber();
        List<Integer> winningNumbers = hitLotto.convertWinningNumbers(stringWinningNumbers);

        // 보너스 볼 입력
        int bonusNumber = inputView.inputBonusNumber();

        // 로또 당첨 확인
        lotto.confirmWinningNumber(winningNumbers, bonusNumber);

        // 당첨 통계 출력
        resultView.printToWinningStatistics(lotto);
    }
}
