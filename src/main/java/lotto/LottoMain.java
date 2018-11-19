package lotto;

import lotto.lottoView.InputView;
import lotto.lottoView.ResultView;

import java.util.List;



public class LottoMain {

    public static void main(String[] args){

        //처음 금액, 수동 입력갯수 입력
        Money money = new Money(InputView.inputInitCost());
        int totalCount = money.getTotalCount();
        int manualCount = InputView.inputManualCount(totalCount);

        Lotteries lotteries = new Lotteries(totalCount);

        //수동 입력 숫자 입력.
        String[] manualLotto = InputView.inputManualNumbers(manualCount);
        List<Lotto> boughtLotteries = lotteries.buyLotto(manualLotto);

        ResultView.printTotalCount(money.getTotalCount(), manualCount); // 갯수 입력& 결과출력
        ResultView.printAllLotteries(boughtLotteries); // 구매한 로또 모두 출력!

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinNumbers(), InputView.inputBonusNumber());

        LottoCompare compare = new LottoCompare();

        LottoResult result = compare.match(boughtLotteries, winningLotto);

        ResultView.winRate(result, money);

    }

}
