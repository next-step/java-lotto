package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        InputView inputView = new InputView();
        InputData inputDataMoney = inputView.inputDataMoney();

        Clerk clerk = new Clerk(inputDataMoney.money());

        int lottoCnt = clerk.returnedLottoCount();
        OutputView outputView = new OutputView(lottoCnt);
        outputView.printLottoCnt();

        for (int i = 0; i < lottoCnt; i++) {
            WholeLottoNumbers wholeLottoNumbers = new WholeLottoNumbers();
            wholeLottoNumbers.createNumber();
            Shuffle shuffle = new Shuffle(wholeLottoNumbers);
            shuffle.shuffle();
            LottoNumber lottoNumber = new LottoNumber(shuffle.extractLottoNumber().numbers());
            lottoNumberList.add(lottoNumber);
        }

        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(lottoNumberList),inputDataMoney.money());

        lottoMachine.startLottoGame();

        InputData inputWinLottoNumber = inputView.inputDataWinLotto();

        OutputData resultData = lottoMachine.showResult(inputWinLottoNumber.lottoNumber());

        outputView.printLottoResult(resultData);

        outputView.printRate(resultData);

    }
}
