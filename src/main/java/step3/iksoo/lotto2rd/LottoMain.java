package step3.iksoo.lotto2rd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMain {
    private static final int PRICE_OF_LOTTO = 1000;

    private static int orderPrice;

    public static void main(String[] args) {
        Lottoes lottos = new Lottoes(buyLotto(lottoOrder()));
        OutputView.printLottos(lottos.getLottoes());

        List<Integer> winNumbers = getKnowWinnerNumbers();
        int bonusBall = getKnowBonusBall();

        int amountPrize = OutputView.printResult(lottos.checkLotteryWin(winNumbers, bonusBall));
        OutputView.printRateProfit(lottos.calculateRateProfit(amountPrize, orderPrice));
    }

    private static int lottoOrder() {
        OutputView.printAskOrder();
        orderPrice = InputView.inputNumber();
        return orderPrice / PRICE_OF_LOTTO;
    }

    private static List<Lotto> buyLotto(int orderCount) {
        List<Lotto> lottoBox = new ArrayList<>();
        IntStream.range(0, orderCount)
                .boxed()
                .forEach(n -> lottoBox.add(new Lotto()));

        OutputView.printOrderCheck(lottoBox.size());
        return lottoBox;
    }

    private static List<Integer> getKnowWinnerNumbers() {
        OutputView.printAskWinnerNumbers();
        String[] numbers = InputView.inputText().replace(" ", "").split(",");

        List<Integer> winnerNumbers = new ArrayList<>();
        for (String number : numbers) {
            winnerNumbers.add(Integer.parseInt(number));
        }
        return winnerNumbers;
    }

    private static int getKnowBonusBall() {
        OutputView.printAskBonusBall();
        return InputView.inputNumber();
    }
}
