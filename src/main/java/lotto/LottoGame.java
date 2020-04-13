package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final String WINNING_DELIMITER = ", ";

    public static void main(String[] args) {
        playLotto();
    }

    public static void playLotto() {
        int paidMoney = InputView.getMoney();

        Lottos lottos = new Lottos(paidMoney);
        ResultView.printLottos(lottos);

        ResultView.printLottoResult(lottos.getResult(WinningNumbers.getInstance(getWinningNumbers())), paidMoney);
    }

    private static List<Integer> getWinningNumbers() {
        String[] inputs = InputView.getWinnerNumber().split(WINNING_DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return winningNumbers;
    }
}
