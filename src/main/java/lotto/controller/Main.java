package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.Shuffler;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Money lottoPrice = LottoPriceMoney.getInstance();
        Money purchaseMoney = InputView.askPurchaseMoney();
        int numOfLottos = (int) purchaseMoney.divide(lottoPrice);
        ResultView.printNumOfLottos(numOfLottos);

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        List<Lotto> lottos = createLottos(numOfLottos, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        ResultView.printLottos(lottos);

        Lotto winningLotto = InputView.askWinningLotto();
        Result result = new Result(lottos, winningLotto);
        ResultView.printStatistics(result, purchaseMoney);
    }

    private static List<Lotto> createLottos(int size, Supplier<Lotto> supplier) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(supplier.get());
        }
        return lottos;
    }
}
