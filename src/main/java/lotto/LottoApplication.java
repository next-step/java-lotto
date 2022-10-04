package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView= new ResultView();
        LottoMachine lottoMachine = new LottoMachine();

        // 금액 입력
        inputView.setPurchaseAmount();

        // 로또 구매
        List<Lotto> lottos = lottoMachine.buyLotto(inputView.getPurchaseAmount());

        // 구매한 로또 현황 출력
        resultView.printLottoNumber(lottos);

        // 지난 주 당첨 번호 입력
        inputView.setLastWeeksCollectNumbers();

        // 결과 저장
        Result result = new Result(lottos, inputView.getLastWeeksCollectNumbers());

        // 당첨 통계 출력
        resultView.printResult(result);
    }

}