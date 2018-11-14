package lotto;

import lotto.lottoView.InputView;
import lotto.lottoView.ResultView;

import java.util.List;


import static lotto.lottoView.InputView.inputWinNumbers;
import static lotto.lottoView.ResultView.printAllLotteries;
import static lotto.lottoView.ResultView.winRate;

public class LottoMain {

    public static void main(String[] args){

        LottoInit cost = new LottoInit(InputView.inputInitCost());
        ResultView.printTotalCount(cost.getCount()); // 갯수 입력& 결과출력

        Lotteries lotteries = new Lotteries(cost.getCount()); //
        List<Lotto> boughtLotteries = lotteries.buyLotto();

        printAllLotteries(boughtLotteries); // 구매한 로또 모두 출력!

        LottoCompare compare = new LottoCompare(inputWinNumbers());
        LottoResult result = compare.match(boughtLotteries);

        winRate(result, cost.getCost());

    }

}
