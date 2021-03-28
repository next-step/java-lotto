package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Market {

    public static final int LOTTO_PRICE = 1000;

    private final Lottos lottos;

    public Market(int cash, List<List<Integer>> lottoNumbers) {
        List<LottoNumberGenerator> lottoNumberGenerators = getLottoNumberGenerators(cash, lottoNumbers);
        this.lottos = new Lottos(lottoNumberGenerators);
    }

    private List<LottoNumberGenerator> getLottoNumberGenerators(int cash, List<List<Integer>> lottoNumbers) {
        int count = getCount(cash, lottoNumbers);

        return Stream.concat(
                Optional.ofNullable(lottoNumbers)
                        .map(Collection::stream)
                        .orElseGet(Stream::empty)
                        .map(lottoNumber -> new LottoFixedLottoNumberGenerator(lottoNumber)),
                IntStream.range(0, count)
                        .mapToObj(index -> new LottoRandomLottoNumberGenerator()))
                .collect(Collectors.toList());
    }

    private int getCount(int cash, List<List<Integer>> lottoNumbers) {
        int count = lottoNumbers.size();
        return (int) Math.abs(count - Math.floor(cash / LOTTO_PRICE));
    }

    public Lottos getLottos() {
        return this.lottos;
    }
}
