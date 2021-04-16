package lotto;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMain {
    public static void main(String[] args) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        InputView inputView = new InputView();
        int money = inputView.inputDataMoney();
        int manualLottoCount = inputView.inputManualLottoCount();

        inputView.printGuideInputManualLotto();

        for (int i = 0; i < manualLottoCount; i++) {
            Set<Integer> inputLottoSet = inputView.inputManualLottoNumber();
            lottoNumberList.add(new LottoNumber(inputLottoSet));
        }

        Clerk clerk = new Clerk(new Money(money), manualLottoCount);

        int totalLottoCount = clerk.returnedLottoTotalCount();
        int autoLottoCount = clerk.returedAutoLottoCount();

        OutputView outputView = new OutputView(totalLottoCount, autoLottoCount, totalLottoCount - autoLottoCount);


        outputView.printLottoCnt();


        for (int i = 0; i < totalLottoCount - manualLottoCount; i++) {
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
