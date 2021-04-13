package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        InputView inputView = new InputView();
        int money = inputView.inputDataMoney();
        Clerk clerk = new Clerk(new Money(money));
        int lottoCount = clerk.returnedLottoCount();
        OutputView outputView = new OutputView(lottoCount);
        outputView.printLottoCnt();

        for (int i = 0; i < lottoCount; i++) {
            WholeLottoNumbers wholeLottoNumbers = new WholeLottoNumbers();
            wholeLottoNumbers.createNumber();
            Shuffle shuffle = new Shuffle(wholeLottoNumbers);
            shuffle.shuffle();
            LottoNumber lottoNumber = new LottoNumber(shuffle.extractLottoNumber().numbers());
            lottoNumberList.add(lottoNumber);
        }

        LottoMachine lottoMachine = new LottoMachine(lottoNumberList, new Money(money));
        lottoMachine.startLottoGame();

        List<Integer> list = inputView.inputDataWinLotto();
        Number bonusNumber = new Number(inputView.inputBonusNumber());

        OutputData resultData = lottoMachine.showResult(list, bonusNumber);

        outputView.printLottoResult(resultData.rankMap());
        outputView.printRate(resultData.calculateWinRate());

    }
}
