package lotto.domain.lotto.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> lottoNumberses = new ArrayList<>();

    public LottoNumbers() {
    }

    public LottoNumbers(List<Integer> inputs) {
        inputs.forEach(input -> lottoNumberses.add(new LottoNumber(input)));
    }

    public List<Integer> numbers() {
        return lottoNumberses.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toUnmodifiableList());
    }

    public int countMatchingNumbers(LottoNumbers target) {
        return (int) lottoNumberses.stream()
            .filter(target::contains)
            .count();
    }

    private boolean contains(LottoNumber target) {
        return this.lottoNumberses.contains(target);
    }

    @Override
    public String toString() {
        return numbers().toString();
    }
}
