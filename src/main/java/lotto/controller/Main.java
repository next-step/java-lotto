package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Shop;
import lotto.domain.WinResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(new RandomLottoGenerator());

        List<Lotto> lottos = shop.buy(InputView.askBuyPrice());
        ResultView.buyResultNotice(lottos);

        WinResult winResult = shop.win(lottos, InputView.askWinLottoNumber());
        ResultView.winResultNotice(winResult);
    }
}
