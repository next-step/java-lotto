package lotto.automatic;

import lotto.automatic.domain.*;
import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

import java.util.List;

public class LottoAutomaticGame {

    public static void main(String ...args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoMoney lottoMoney = inputView.getLottoMoney();
        LottoGenerator generator = new LottoGenerator(new RandomShuffle());
        List<Lotto> lottoList = generator.generateLotto(lottoMoney.getCountOfLotto());

        outputView.printLottos(lottoList);

        LottoWinningNums winningLottoNums = inputView.getWinningLottoNums();

        Lotto winningLotto = winningLottoNums.getWinningLotto();

        LottoResult result = new LottoResult(lottoList, winningLotto);

        outputView.printLottoResult(lottoMoney, result);


    }

}
