package lotto.service;

import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.domain.LottoWinnerNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {

    private LottoMoney lottoMoney;
    private LottoList lottoList;
    private LottoWinnerNumber lottoWinnerNumber;

    public void lottoGame() {
        changeCoin();
        createLottoNumber();
        createWinnerNumbers();

    }

    private void createWinnerNumbers() {
        lottoWinnerNumber = new LottoWinnerNumber();
        lottoWinnerNumber.splitStringNumbers(InputView.inputPrizeNumbers());
    }

    private void createLottoNumber() {
        lottoList = new LottoList();
        lottoList.createAutoNumber(lottoMoney.getCoin());
        ResultView.printBuyLottoNumber(lottoList.getLottoList());
    }

    private void changeCoin() {
        lottoMoney = new LottoMoney(InputView.inputPurchaseAmount());
        ResultView.printCoinAndRemainMoney(lottoMoney);
    }
}
