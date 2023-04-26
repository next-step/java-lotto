package step2.domain.model;

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

    public static Lotto createLotto(Strategy strategy) {
        return new Lotto(LottoNumbers.createLottoNumbers(strategy));
    }

    public static Lotto createWinnerLotto(Strategy strategy, String lastWinningNumbers) {
        return new Lotto(LottoNumbers.createWinnerLottoNumbers(strategy, lastWinningNumbers));
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

    @Override
    public String toString() {
        String lottoNumbers = numbers.getLottoNumbers()
                .stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(", "));

        return String.format("[%s]", lottoNumbers);
    }
}
