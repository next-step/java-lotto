package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGenerator {
    public static final Price UNIT_PRICE = new Price(1000);

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        return LazyHolder.instance;
    }

    public List<Lotto> generate(Price price) {
        return LongStream.range(0, getCount(price))
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public Lotto generate(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    private final static class LazyHolder {
        private final static LottoGenerator instance = new LottoGenerator();
    }

    private long getCount(Price price) {
        return price.divide(UNIT_PRICE);
    }
}
