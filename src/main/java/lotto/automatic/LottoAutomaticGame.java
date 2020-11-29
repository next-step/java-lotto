package lotto.automatic;

import lotto.automatic.domain.*;
import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

import java.util.List;

public class LottoAutomaticGame {

    public static void main(String ...args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoBuyingMoney lottoBuyingMoney = inputView.getLottoMoney();
        LottoGenerator generator = new LottoGenerator(new RandomShuffle());
        List<Lotto> lottoList = generator.generateLotto(lottoBuyingMoney.getCountOfLotto());

        outputView.printLottoList(lottoList);

        LottoWinningNums winningLottoNums = inputView.getWinningLottoNums();

        Lotto winningLotto = new Lotto(winningLottoNums.getLottoNumbers());

        LottoRankCollector collector = new LottoRankCollector(lottoList, winningLotto);
        LottoResult result = new LottoResult(lottoBuyingMoney.getInvestMoney(), collector.getRankList());

        outputView.printLottoResult(result);


    }

}
