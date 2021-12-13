package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumbers;
import lotto.lotto.Lottos;
import lotto.result.LottoResults;
import lotto.result.MatchedNumbersCount;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        int quantity = purchaseAmount / LOTTO_PRICE;
        ResultView.printQuantity(quantity);

        Lottos lottos = lottos(quantity);
        LottoNumbers winningNumbers = draw();
        LottoResults lottoResults = match(lottos, winningNumbers);

        float profit = lottoResults.prize() / purchaseAmount;
        ResultView.printResult(lottoResults, profit);
    }

    private static LottoResults match(Lottos lottos, LottoNumbers winningNumbers) {
        Map<MatchedNumbersCount, Long> lottoResults = new EnumMap<>(MatchedNumbersCount.class);

        for (MatchedNumbersCount matchedNumbersCount : MatchedNumbersCount.values()) {
            long matchedLottosCount = lottos.match(winningNumbers, matchedNumbersCount);
            lottoResults.put(matchedNumbersCount, matchedLottosCount);
        }

        return new LottoResults(lottoResults);
    }

    private static LottoNumbers draw() {
        InputView.printWinningNumbersRequest();
        return winningNumbers();
    }

    private static Lottos lottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = LottoMachine.generateLottoNumber();
            Lotto lotto = Lotto.from(lottoNumbers);
            lottos.add(lotto);

            ResultView.printLottoNumbers(lotto);
        }

        return new Lottos(lottos);
    }

    private static LottoNumbers winningNumbers() {
        String[] input = InputView.getWinningNumbers();

        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return LottoNumbers.from(winningNumbers);
    }
}
