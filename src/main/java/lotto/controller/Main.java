package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.LottoPrice;
import lotto.domain.WinResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoPrice lottoPrice = new LottoPrice(new RandomLottoGenerator());

        List<Lotto> lottos = lottoPrice.buy(InputView.askBuyPrice());
        ResultView.buyResultNotice(lottos);

        WinResult winResult = lottoPrice.win(lottos, InputView.askWinLottoNumber(), InputView.askBonusLottoNumber());
        ResultView.winResultNotice(winResult);
    }
}
