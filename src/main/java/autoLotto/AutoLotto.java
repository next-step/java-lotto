package autoLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    private List<Lotto> numbers;

    public AutoLotto(int count) {
        numbers = IntStream.range(0, count)
                           .mapToObj(lotto -> generate())
                           .collect(Collectors.toList());
    }

    private Lotto generate() {
        return new Lotto(lottoGenerator.generate());
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                      .map(Lotto::toString)
                      .collect(Collectors.joining("\n"));
    }
}
