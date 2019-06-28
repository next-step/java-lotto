package step4.iksoo.lottoManual;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoMain {
    private static int orderPrice;
    private static int orderManualLotto;

    public static void main(String[] args) {
        List<String> manualNumbers = lottoOrder();
    	Optional<Lottoes> maybeLottoes = Optional.of(new Lottoes(orderPrice, manualNumbers));

        OutputView.printOrderCheck(maybeLottoes.get().getLottoes().size(), orderManualLotto);
        OutputView.printLottos(maybeLottoes.get().getLottoes());

        Lotto winNumbers = getKnowWinnerNumbers();
        LottoNo bonusBall = getKnowBonusBall(winNumbers);

        Optional<MatchResult> maybeMatchResult = Optional.ofNullable(new MatchResult(maybeLottoes.get().checkLotteryWin(winNumbers, bonusBall)));
        OutputView.printResult(maybeMatchResult.get().getMatchResult());
        OutputView.printRateProfit(maybeMatchResult.get().calculateRateProfit(orderPrice));
    }

    private static List<String> lottoOrder() {
        OutputView.printAskOrderPrice();
        orderPrice = InputView.inputNumber();
        
        OutputView.printAskManualOrder();
        orderManualLotto = InputView.inputNumber();

        return orderManualLottoNumbers(orderManualLotto);
    }

    private static List<String> orderManualLottoNumbers(int orderManualLotto) {
        List<String> lottoManual = new ArrayList<>();
        OutputView.printAskManualNumbers();

        IntStream.range(0, orderManualLotto)
                .boxed()
                .forEach(n -> lottoManual.add(InputView.inputText()));
        return lottoManual;
    }

	private static Lotto getKnowWinnerNumbers() {
        OutputView.printAskWinnerNumbers();
        String[] numbers = InputView.inputText().replace(" ", "").split(",");

        List<Integer> winnerNumbers = new ArrayList<>();
        for (String number : numbers) {
            winnerNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(winnerNumbers);
    }

    private static LottoNo getKnowBonusBall(Lotto winnerNumbers) {
        OutputView.printAskBonusBall();
        LottoNo bonusBall = new LottoNo(InputView.inputNumber());

        winnerNumbers.getLotto().stream()
                .filter(number -> number == bonusBall.getNumber())
                .peek(dos -> {
                    throw new IllegalArgumentException("보너스볼 번호가 당첨 번호의 숫자와 동일합니다.");
                })
                .findAny();

        return bonusBall;
    }
}
