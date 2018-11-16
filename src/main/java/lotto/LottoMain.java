package lotto;

import lotto.lottoView.InputView;
import lotto.lottoView.ResultView;

import java.util.List;

import static lotto.lottoView.InputView.inputBonusNumber;
import static lotto.lottoView.InputView.inputWinNumbers;
import static lotto.lottoView.ResultView.printAllLotteries;
import static lotto.lottoView.ResultView.winRate;

public class LottoMain {

    public static void main(String[] args){

        LottoInit init = new LottoInit(InputView.inputInitCost());

        Lotteries lotteries = new Lotteries(init); //
        List<Lotto> boughtLotteries = lotteries.buyLotto();

        ResultView.printTotalCount(init); // 갯수 입력& 결과출력
        printAllLotteries(boughtLotteries); // 구매한 로또 모두 출력!

        WinningLotto winningLotto = new WinningLotto(inputWinNumbers(), inputBonusNumber());

        LottoCompare compare = new LottoCompare();

        LottoResult result = compare.match(boughtLotteries, winningLotto);

        winRate(result, init.getCost());

    }

}
