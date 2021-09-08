package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {
        int amount = inputAmount();
        if (amount < 0) {
            InputView.printInputError();
            return;
        }

        int totalCount = calculateCount(amount);
        if (totalCount < 0) {
            InputView.printZeroCountError();
            return;
        }
        ResultView.printCount(totalCount);

        Lottos lottos = getLottos(totalCount);
        ResultView.printLottoList(lottos);
        InputView.refreshLine();

        List<Integer> winningNumbers = inputWinningNumbers();
        if (winningNumbers == null) {
            InputView.printInputError();
            return;
        }

        Lotto winningLotto = getWinningLotto(winningNumbers);
        ResultView.printResult(lottos.result(winningLotto, amount));
    }

    private static Lotto getWinningLotto(List<Integer> winningNumbers) {
        List<LottoNumber> winningLottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        try {
            String numbers = InputView.getWinningNumbers();
            winningNumbers= StringParser.parseIntList(numbers);
        } catch (NumberFormatException e) {
            return null;
        }
        return winningNumbers;
    }

    private static Lottos getLottos(int totalCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateLotto(totalCount);
    }

    private static int calculateCount(int amount) {
        int totalCount = LottoPrice.getAvailableCount(amount);
        if (totalCount == 0) return -1;
        return totalCount;
    }

    private static int inputAmount() {
        int amount;
        try {
            amount = InputView.getPurchaseAmount();
        } catch (RuntimeException e) {
            return -1;
        }
        return amount;
    }
}
