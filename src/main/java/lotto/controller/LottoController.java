package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Rankings;
import lotto.model.Seller;
import lotto.util.LottoNumbersCreator;
import lotto.util.NumbersCreator;
import lotto.util.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;
import stringcalculator.model.Input;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {


    public static void run() {
        int buyAmount = InputView.inputBuyAmount();
        int buyCount = InputView.calculateBuyCount(buyAmount);

        Buyer buyer = Buyer.of(buyCount, new LottoNumbersCreator());

        ResultView.printBuyerLottosInfo(buyer);

        Lotto winningLotto = Lotto.of(InputView::inputWinningLottoNumbers);
        Seller seller = Seller.of(winningLotto);
        Rankings rankings = buyer.rankings(seller);

        ResultView.printStatistics(buyCount, rankings);
    }
}
