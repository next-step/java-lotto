package step2.domain.model.Lotto;

import step2.domain.strategy.lotto.Strategy;

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

    public void calculatorLottoWinningCount(Lotto winningLotto) {
        Map<Integer, Integer> lottoWinningNumbers = winningLotto.getNumbers()
                .stream()
                .collect(Collectors.toMap(LottoNumber::getNumber, LottoNumber::getNumber));

        for (LottoNumber lottoNumber : numbers.getLottoNumbers()) {
            if (lottoWinningNumbers.containsKey(lottoNumber.getNumber())) {
                winningCount++;
            }
        }
    }

    public int getWinningCount() {
        return winningCount;
    }
}
