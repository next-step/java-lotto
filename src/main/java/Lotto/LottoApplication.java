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
        ResultView.inputManualLottoCount();
        int count = (int) paidAmount / LOTTO_PRICE;
        int manualLottoCount = InputView.inputInteger();
        int autoCount = count - manualLottoCount;

        buyManualLotto(manualLottoCount);
        ResultView.purchased(manualLottoCount, autoCount);
        buyAutoLotto(autoCount);
    }

    private static void buyAutoLotto(int count) {
        for (int i = 0; i < count; i++) {
            myLotto.add(new Lotto());
        }
    }

    private static void buyManualLotto(int count) {
        ResultView.inputManualLottoNumbers();
        for (int i = 0; i < count; i ++) {
            myLotto.add(new Lotto(splitNumbers(InputView.inputString())));
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
        List<LottoNumber> numbers = splitNumbers(values);
        winnerLotto = new WinningLotto(numbers, bonusNumber);
    }

    private static List<LottoNumber> splitNumbers(String values) {
        return Arrays.stream(values.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .map(number -> LottoNumber.of(number))
                .collect(Collectors.toList());
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
