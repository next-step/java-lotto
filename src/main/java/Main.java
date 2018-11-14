import Domain.*;
import View.InputView;

import java.util.*;

import static Domain.Money.calculateAmount;
import static View.InputView.printLastWeekWinNumber;
import static View.InputView.printLottoAmount;
import static View.InputView.printLottoNumber;
import static View.OutputView.printRankAmount;
import static View.OutputView.printResultNotice;
import static View.OutputView.printResultYield;
import static util.ConsoleUtil.changeWinNumberToInteger;
import static util.Validation.validatePurchaseAmount;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);

        int amount = calculateAmount(purchaseAmount);
        printLottoAmount(amount);

        NumberGenerator generator = new RandomNumberGenerator();
        Lotto lotto = new Lotto(amount, generator);
        List<Attempt> lottoNumbers = lotto.getLottoNumbers();
        printLottoNumber(lottoNumbers);

        String winnerNumber = printLastWeekWinNumber();
        List<Integer> numbers = changeWinNumberToInteger(winnerNumber);
        lotto.calculateAllRank(numbers);

        printResultNotice();

        RankAmount rankLongMap = new RankAmount(lottoNumbers);
        printRankAmount(rankLongMap);

        float v = rankLongMap.calculateYeild(purchaseAmount);
        printResultYield(v);
    }
}
