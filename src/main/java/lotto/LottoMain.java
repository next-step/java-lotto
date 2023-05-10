package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoCreationStrategy;
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

        resultView.showLottos(createdLottos);

        LottoResult lottoResult = lottos.judge(createdLottos, inputView.requestWinningNumbers()); // 당첨 결과 산출
        resultView.showResults(lottoResult);
    }
}
