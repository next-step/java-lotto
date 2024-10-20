package lotto;

import lotto.ui.InputView;
import random.LottoGenerateStrategy;
import random.RandomLottoNumbers;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = InputView.purchaseAmount(scanner);
        Lotto lotto = Lotto.InitLotto(purchaseAmount, new LottoGenerateStrategy(new RandomLottoNumbers()));
        LottoWinner lottoWinner = new LottoWinner(InputView.lottoWinnerNumbers(scanner));
        lotto.searchWinningCount(lottoWinner);
        lottoWinner.printWinningCount();
        ProfitMargin profitMargin = new ProfitMargin(lottoWinner.winningAmount(), purchaseAmount);
        profitMargin.printMargin();
    }

}
