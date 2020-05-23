package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNum;
import lotto.domain.LottoNums;
import lotto.domain.LottoPaper;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCustomer {

    public static void main(String[] args) {
        int price = InputView.requestPrice();
        List<LottoNums> lottoNumsList = InputView.requestManualNumsList().stream().map(LottoNums::of).collect(Collectors.toList());

        LottoSeller lottoSeller = new LottoSeller();
        LottoPaper lottoPaper = lottoSeller.sell(price, lottoNumsList);

        OutputView.printLottos(lottoPaper.getLottoLines());

        LottoNums lottoNums = LottoNums.of(InputView.requestWinNums());

        OutputView.printLottoResult(
            lottoPaper.getResult(lottoNums, new LottoNum(InputView.requestBonusNum()), price));
    }

}
