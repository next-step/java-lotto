package deprecatedlotto.controller;

import deprecatedlotto.domain.Lotto;
import deprecatedlotto.domain.LottoWinner;
import deprecatedlotto.domain.ProfitMargin;
import deprecatedlotto.ui.InputView;
import deprecatedlotto.random.LottoGenerateStrategy;
import deprecatedlotto.random.RandomLottoNumbers;

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
