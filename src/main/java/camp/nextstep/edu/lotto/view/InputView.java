package camp.nextstep.edu.lotto.view;

import java.util.List;
import java.util.Set;

public interface InputView {
    int inputInvestment();

    int inputNumberOfCustomizedLotteries();

    List<List<Integer>> inputNumbersForCustomizedLotteries(int numberOfCustomizedLotteries);

    Set<Integer> inputWinningNumbers();

    int inputBonusNumber();
}
