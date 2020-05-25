package lotto;

import java.util.List;
import lotto.domain.LottoNum;
import lotto.domain.LottoNums;
import lotto.domain.LottoPaper;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCustomer {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int price = inputView.requestPrice();
        List<LottoNums> manualLottoNumsList = inputView.requestManualNumsList();

        LottoSeller lottoSeller = new LottoSeller();
        LottoPaper lottoPaper = lottoSeller.sell(price, manualLottoNumsList);

        OutputView outputView = new OutputView();
        outputView.printLottoPaper(lottoPaper);

        LottoNums winNums = inputView.requestWinNums();
        outputView.printLottoResult(
            lottoPaper.getResult(winNums, new LottoNum(inputView.requestBonusNum()), price));
    }

}
