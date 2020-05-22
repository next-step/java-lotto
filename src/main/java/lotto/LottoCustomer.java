package lotto;

import java.util.List;
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

        List<Integer> winNums = InputView.requestNums();

        LottoNums lottoNums = LottoNums.of(winNums);

        OutputView.printLottoResult(lottoPaper.getResult(lottoNums, price));
    }

}
