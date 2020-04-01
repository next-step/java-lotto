package lotto;

import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final String WINNING_DELIMITER = ", ";

    public static void main(String[] args) {
        playLotto();
    }

    public static void playLotto() {
        int paidMoney = InputView.getMoney();

        Lotto lotto = issueLotto(paidMoney);
        ResultView.printIssuedLotto(lotto);

        ResultView.printLottoResult(lotto.getResult(getWinningNumbers()), paidMoney);

    }

    private static List<Integer> getWinningNumbers() {
        String[] inputs = InputView.getWinnerNumber().split(WINNING_DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return winningNumbers;
    }

    public static Lotto issueLotto(int price) {
        return new Lotto(price / LOTTO_PRICE);
    }
}
