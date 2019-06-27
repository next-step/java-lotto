package step4.iksoo.lottoManual;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoMain {
    private static int orderPrice;
    private static int orderManualLotto;

    public static void main(String[] args) {
        lottoOrder();
    	Optional<Lottoes> maybeLottoes = Optional.ofNullable(new Lottoes(orderPrice, orderManualLotto));
        OutputView.printLottos(maybeLottoes.get().getLottoes());

        List<Integer> winNumbers = getKnowWinnerNumbers();
        int bonusBall = getKnowBonusBall(winNumbers);

        Optional<MatchResult> maybeMatchResult = Optional.ofNullable(new MatchResult(maybeLottoes.get().checkLotteryWin(winNumbers, bonusBall)));
        OutputView.printResult(maybeMatchResult.get().getMatchResult());
        OutputView.printRateProfit(maybeMatchResult.get().calculateRateProfit(orderPrice));
    }

    private static void lottoOrder() {
        OutputView.printAskOrderPrice();
        orderPrice = InputView.inputNumber();
        
        OutputView.printAskManualOrder();
        orderManualLotto = InputView.inputNumber();
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

    private static int getKnowBonusBall(List<Integer> winnerNumbers) {
        OutputView.printAskBonusBall();
        int bonusBall = InputView.inputNumber();

        winnerNumbers.stream()
                .filter(number -> number == bonusBall)
                .peek(dos -> {
                    throw new IllegalArgumentException("보너스볼 번호가 당첨 번호의 숫자와 동일합니다.");
                })
                .findAny();

        return bonusBall;
    }
}
