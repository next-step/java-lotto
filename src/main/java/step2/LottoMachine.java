package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());
    }
}
