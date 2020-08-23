package step2.domain.lotto;

import step2.util.NumberGenerator;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createLottoNumbers(NumberGenerator lottoNumberGenerator) {
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator()
                .stream()
                .sorted(Comparator.comparingInt(LottoNumber::getLottoNumber))
                .collect(toList());
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(toList());
    }

    public int getHitCount(List<Integer> winningLotto) {
        return (int)winningLotto.stream()
                .map(LottoNumber::new)
                .filter(numbers::contains)
                .count();
    }
}
