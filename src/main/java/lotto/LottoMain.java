package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int purchaseCount = Lotto.findPurchaseCount(inputView.requestPurchaseAmount()); // 구입 금액으로부터 구입 개수 산출
        resultView.showPurchaseCount(purchaseCount);

        RandomLottoCreationStrategy randomLottoCreationStrategy = new RandomLottoCreationStrategy(); // 전략 설정
        Lottos lottos = new Lottos(purchaseCount, randomLottoCreationStrategy);
        List<Lotto> createdLottos = lottos.getCreatedLottos(); // 로또 리스트 만들기

        resultView.showLottos(createdLottos); // 만들어진 로또 산출

        WinningLotto winningLotto = new WinningLotto(inputView.requestWinningNumbers(), inputView.requestBonusNumber()); // 당첨 번호, 보너스 번호 입력
        resultView.showResults(lottos.judge(createdLottos, winningLotto)); // 당첨 결과 산출
    }
}
