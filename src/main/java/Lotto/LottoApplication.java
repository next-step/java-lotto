package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final int LOTTO_PRICE = 1000;

    private static final List<Lotto> myLotto = new ArrayList<>();
    private static WinningLotto winnerLotto;
    private static double paidAmount;

    public static void main(String[] args) {
        LottoApplication.start();
    }

    private static void start() {
        buy();
        showLottoNumbers();
        makeWinnerLotto();
        showResult();
    }

    private static void buy() {
        ResultView.inputAmount();
        paidAmount = InputView.inputInteger();
        int count = (int) paidAmount / LOTTO_PRICE;
        ResultView.purchased(count);
        buyLotto(count);
    }

    private static void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            myLotto.add(new Lotto());
        }
    }

    private static void showLottoNumbers() {
        ResultView.printLine();
        for (Lotto lotto : myLotto) {
            ResultView.showLottoNumbers(lotto.getSortedNumbers());
        }
        ResultView.printLine();
    }

    private static void makeWinnerLotto() {
        ResultView.inputWinnerLotto();
        String values = InputView.inputString();
        ResultView.inputBonusNumber();
        int bonusNumber = InputView.inputInteger();
        List<LottoNumber> numbers = Arrays.stream(values.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
        winnerLotto = new WinningLotto(numbers, bonusNumber);
    }

    private static void showResult() {
        MyRank myRank = new MyRank();
        for (Lotto lotto : myLotto) {
            Rank rank = Rank.getRank(winnerLotto, lotto);
            myRank.add(rank);
        }
        ResultView.result(myRank);
        ResultView.profit(myRank.profit(paidAmount));
    }
}
