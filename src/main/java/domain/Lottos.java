package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottoList;
    private final LottoGenerator lottoGenerator;

    public Lottos(LottoGenerator lottoGenerator, int count) {
        this.lottoGenerator = lottoGenerator;
        this.lottoList = create(count);
    }

    private List<Lotto> create(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoGenerator.generate()))
                .collect(Collectors.toList());
    }

    public int calculateNumbers(Lotto winningNumbers, int count) {
        return Math.toIntExact(this.lottoList
                .stream()
                .filter(lotto -> lotto.compare(winningNumbers).size() == count)
                .count());
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(lotto -> lotto + "\n")
                .collect(Collectors.joining());
    }
}
