package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMain {
    private static final int PRICE_OF_LOTTO = 1000;

    public static void main(String[] args) {
        Lottos lottos = new Lottos(buyLotto(lottoOrder()));
        OutputView.printLottos(lottos.getLottos());

        List<Integer> winNumbers = getKnowWinnerNumbers();
        int amoutPrize = OutputView.printResult(lottos.checkLotteryWin(winNumbers));
        OutputView.printRateProfit(lottos.calculateRateProfit(amoutPrize));
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

    private static int lottoOrder() {
        OutputView.printAskOrder();
        return InputView.inputNumber() / PRICE_OF_LOTTO;
    }

    private static List<Lotto> buyLotto(int orderCount) {
        List<Lotto> lottoBox = new ArrayList<>();
        IntStream.range(0, orderCount)
                .boxed()
                .forEach(n -> lottoBox.add(new Lotto()));

        OutputView.printOrderCheck(lottoBox.size());
        return lottoBox;
    }
}
