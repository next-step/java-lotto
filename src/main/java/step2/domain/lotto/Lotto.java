package step2.domain.lotto;

import step2.util.LottoNumberGenerator;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createLottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
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
