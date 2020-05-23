package lotto;

import lotto.domain.LottoNum;
import lotto.domain.LottoNums;
import lotto.domain.LottoPaper;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCustomer {

    public static void main(String[] args) {
        int price = InputView.requestPrice();

        LottoSeller lottoSeller = new LottoSeller();
        LottoPaper lottoPaper = lottoSeller.sell(price);

        OutputView.printLottos(lottoPaper.getLottoLines());

        LottoNums lottoNums = LottoNums.of(InputView.requestNums());

        OutputView.printLottoResult(
            lottoPaper.getResult(lottoNums, new LottoNum(InputView.requestBonusNum()), price));
    }

}
