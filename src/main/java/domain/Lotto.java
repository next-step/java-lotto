package domain;

import strategy.LottoNumberGenerator;
import study.ValidateUtil;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {
    private List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }
    
    public static Lotto of(LottoNumberGenerator randomLottoNumberGenerator) {
        List<LottoNumber> lottoNumbers = randomLottoNumberGenerator
                .generator()
                .stream()
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .collect(toList());
        ValidateUtil.validateLottoNumberCount(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .collect(toList());
    }

    public long hasWinningNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .map(LottoNumber::of)
                .filter(numbers::contains)
                .count();
    }
}
