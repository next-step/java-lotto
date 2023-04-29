package step3.domain.model.Lotto;

import step3.domain.strategy.lotto.Strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Lotto {
    private LottoNumbers numbers;
    private int winningCount = 0;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(Strategy strategy) {
        return new Lotto(strategy.createLottoNumbers());
    }

    public static Lotto fromWinningLotto(Strategy strategy, String lastWinningNumbers) {
        return new Lotto(strategy.createWinningLottoNumber(lastWinningNumbers));
    }

    public List<LottoNumber> getNumbers() {
        return numbers.getLottoNumbers();
    }

    public void calculatorLottoWinning(Lotto winningLotto) {
        Map<Integer, Integer> lottoWinningNumbers = convertLottoNumbersToMap(winningLotto);

        for (LottoNumber lottoNumber : numbers.getLottoNumbers()) {
            if (lottoWinningNumbers.containsKey(lottoNumber.getNumber())) {
                winningCount++;
            }
        }
    }

    private Map<Integer, Integer> convertLottoNumbersToMap(Lotto winningLotto) {
        return winningLotto.getNumbers()
                .stream()
                .collect(Collectors.toMap(LottoNumber::getNumber, LottoNumber::getNumber));
    }

    public int getWinningCount() {
        return winningCount;
    }
}
