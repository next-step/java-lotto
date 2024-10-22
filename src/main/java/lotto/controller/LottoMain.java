package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.ProfitMargin;
import lotto.ui.InputView;
import random.LottoGenerateStrategy;
import random.RandomLottoNumbers;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = InputView.purchaseAmount(scanner);
        Lotto lotto = Lotto.InitLotto(purchaseAmount, new LottoGenerateStrategy(new RandomLottoNumbers()));
        lotto.insertWinningLottoNumber(new LottoWinner(InputView.lottoWinnerNumbers(scanner)));
        lotto.recordWinningCount();

        lotto.printWinningCount();
        ProfitMargin profitMargin = new ProfitMargin(lotto.winningAmount(), purchaseAmount);
        profitMargin.printMargin();
    }

}
