package autoLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    private List<Lotto> lottos;

    public AutoLotto(int count) {
        lottos = IntStream.range(0, count)
                          .mapToObj(lotto -> generate())
                          .collect(Collectors.toList());
    }

    private Lotto generate() {
        return new Lotto(lottoGenerator.generate());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                     .map(Lotto::toString)
                     .collect(Collectors.joining("\n"));
    }
}
