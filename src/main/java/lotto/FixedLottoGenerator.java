package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoGenerator implements LottoGenerator {
    private List<LottoNumber> numbers;

    public FixedLottoGenerator(final List<Integer> numbers) {
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    @Override
    public Lotto generateLotto() {
        List<LottoNumber> newNumbers = new ArrayList<>(numbers);
        numbers = numbers.stream().map(LottoNumber::increase).collect(Collectors.toList());
        return new Lotto(newNumbers);
    }
}
