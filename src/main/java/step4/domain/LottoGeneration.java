package step4.domain;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneration {

    private final List<Integer> numbers;
    private int count;

    public LottoGeneration(List<Integer> number, int count) {
        this.numbers = number;
        this.count = count;
    }

    public List<Lotto> getGeneratedLottos() {
        return IntStream.range(0, count)
                .mapToObj(index -> new Lotto(getGeneratedNumbers()))
                .collect(Collectors.toList());
    }


    private Set<LottoNumber> getGeneratedNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
