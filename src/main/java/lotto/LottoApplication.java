package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoWrapper;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();

        // 금액 입력
        int purchaseAmount = inputView.inputPurchaseAmount();

        // 수동 로또 개수 입력
        int passiveLottoCount = inputView.inputPassiveLottoCount();
//        int passiveLottoCount = 3;

        // 수동 로또 번호 입력
        List<List<Integer>> numbersCollection = inputView.inputPassiveLottoNumbers(passiveLottoCount);
//        List<List<Integer>> numbersCollection = new ArrayList<>();
//        numbersCollection.add(Arrays.asList(8, 21, 23, 41, 42, 43));
//        numbersCollection.add(Arrays.asList(3, 5, 11, 16, 32, 38));
//        numbersCollection.add(Arrays.asList(7, 11, 16, 35, 36, 44));

        // 로또 구매
        LottoWrapper lottoWrapper = lottoMachine.buyLotto(purchaseAmount, passiveLottoCount, numbersCollection);

        // 구매한 로또 현황 출력
        resultView.printLottoState(lottoWrapper, passiveLottoCount);

        // 지난 주 당첨 번호 입력
        List<Integer> lastWeeksCollectNumbers = inputView.inputLastWeeksCollectNumbers();

        // 보너스 볼 번호 입력
        int bonusNumber = inputView.inputBonusNumber();

        // 결과 저장
        Result result = new Result(lottoWrapper, lastWeeksCollectNumbers, bonusNumber);

        // 당첨 통계 출력
        resultView.printResult(result);
    }

}