package step2.domain;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateLotto {

    public static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_RANGE = 6;

    private final List<Integer> numbers;
    private int cash;

    public GenerateLotto(List<Integer> number, int cash) {
        this.numbers = number;
        this.cash = cash;
    }

    public List<Lotto> getGeneratedLottos() {
        int count = getCount();

        return IntStream.range(0, count)
                .mapToObj(index -> getGeneratedLotto())
                .collect(Collectors.toList());
    }

    private int getCount() {
        return (int) Math.floor(cash / LOTTO_PRICE);
    }

    private Lotto getGeneratedLotto() {
        Set<LottoNumber> lottoNumbers = getGeneratedNumbers().stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return new Lotto(lottoNumbers);
    }

    private Set<Integer> getGeneratedNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_RANGE)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


}
