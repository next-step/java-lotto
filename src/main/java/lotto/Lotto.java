package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumberList;
    private final static int LOTTO_SIZE = 6;

    public static Lotto create(LottoGeneration generation) {
        return new Lotto(generation);
    }

    private Lotto(LottoGeneration generation) {
        List<Integer> generate = generation.generate();
        this.lottoNumberList = generate.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> numbers() {
        return this.lottoNumberList;
    }
}
