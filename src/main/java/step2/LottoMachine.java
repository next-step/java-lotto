package step2;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLottos(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());
    }

    public Map<LottoResult, Integer> getLottoResults(List<Lotto> lottos, Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> LottoResult.getResult(lotto, winningLotto))
                .collect(Collectors.groupingBy(lottoResult ->
                        lottoResult, Collectors.summingInt(e -> 1)));
    }
}
