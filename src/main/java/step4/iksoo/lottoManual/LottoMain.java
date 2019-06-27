package step4.iksoo.lottoManual;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoMain {
    private static int orderPrice;
    private static int orderManualLotto;

    public static void main(String[] args) {
        lottoOrder();
    	Optional<Lottoes> maybeLottoes = Optional.ofNullable(new Lottoes(orderPrice, orderManualLotto));
        maybeLottoes.get().add(buyManualLotto(orderManualLotto));

        OutputView.printOrderCheck(maybeLottoes.get().getLottoes().size(), orderManualLotto);
        OutputView.printLottos(maybeLottoes.get().getLottoes());

        List<LottoNo> winNumbers = getKnowWinnerNumbers();
        LottoNo bonusBall = getKnowBonusBall(winNumbers);

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

    private static List<Lotto> buyManualLotto(int orderManualLotto) {
        List<Lotto> lottoManual = new ArrayList<>();
        OutputView.printAskManualNumbers();

        IntStream.range(0, orderManualLotto)
                .boxed()
                .map(n -> new LottoManualSplit(InputView.inputText()))
                .forEach(lottoManualSplit -> lottoManual.add(new Lotto(lottoManualSplit.getLottoNumbers())));
        return lottoManual;
    }

	private static List<LottoNo> getKnowWinnerNumbers() {
        OutputView.printAskWinnerNumbers();
        String[] numbers = InputView.inputText().replace(" ", "").split(",");

        List<LottoNo> winnerNumbers = new ArrayList<>();
        for (String number : numbers) {
            winnerNumbers.add(new LottoNo(Integer.parseInt(number)));
        }
        return winnerNumbers;
    }

    private static LottoNo getKnowBonusBall(List<LottoNo> winnerNumbers) {
        OutputView.printAskBonusBall();
        LottoNo bonusBall = new LottoNo(InputView.inputNumber());

        winnerNumbers.stream()
                .filter(number -> number == bonusBall)
                .peek(dos -> {
                    throw new IllegalArgumentException("보너스볼 번호가 당첨 번호의 숫자와 동일합니다.");
                })
                .findAny();

        return bonusBall;
    }
}
