package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Lotto> lottos = new ArrayList<>();

        int buyPrice = InputView.askBuyPrice();
        int manuallyBuyCount = InputView.askManuallyBuyCount();

        List<Lotto> manuallyLottos = manuallyBuyLotto(manuallyBuyCount);
        List<Lotto> automaticallyLottos = automaticallyBuyLotto(buyPrice, manuallyBuyCount);

        lottos.addAll(manuallyLottos);
        lottos.addAll(automaticallyLottos);

        ResultView.buyResultNotice(lottos, manuallyLottos.size(), automaticallyLottos.size());

        WinResult winResult = LottoPrice.win(lottos, InputView.askWinLottoNumber(), InputView.askBonusLottoNumber());
        ResultView.winResultNotice(winResult);
    }

    private static List<Lotto> automaticallyBuyLotto(final int buyPrice, final int manuallyBuyCount) {
        return LottoPrice.buy(new RandomLottoGenerator(), automaticallyBuyPrice(buyPrice, manuallyBuyCount));
    }

    private static List<Lotto> manuallyBuyLotto(final int manuallyBuyCount) {
        return LottoPrice.buy(new FixedLottoGenerator(InputView.askManuallyBuyLottoNumbers(manuallyBuyCount)), manuallyBuyPrice(manuallyBuyCount));
    }

    private static int automaticallyBuyPrice(final int buyPrice, final int manuallyBuyCount) {
        return buyPrice - manuallyBuyPrice(manuallyBuyCount);
    }

    private static int manuallyBuyPrice(final int manuallyBuyCount) {
        return manuallyBuyCount * LottoPrice.LOTTO_PRICE;
    }
}
