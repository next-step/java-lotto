import domain.*;
import view.InputView;

import java.util.*;

import static domain.Money.calculateAmount;
import static view.InputView.printLastWeekWinNumber;
import static view.InputView.printLottoAmount;
import static view.InputView.printLottoNumber;
import static view.OutputView.printRankAmount;
import static view.OutputView.printResultNotice;
import static view.OutputView.printResultYield;
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
