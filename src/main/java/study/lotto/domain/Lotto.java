package study.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static study.lotto.domain.LottoNumber.MAX_NUMBER_BOUND;
import static study.lotto.domain.LottoNumber.MIN_NUMBER_BOUND;

public class Lotto {

    public static final int LOTTO_MAX_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto() {
        this.lotto = createLottoNumbers();
        shuffle();
    }

    private List<LottoNumber> createLottoNumbers() {
        return IntStream.range(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    protected void shuffle() {
        Collections.shuffle(lotto);
    }

    public List<LottoNumber> getLotto() {
        List<LottoNumber> collect = lotto.stream()
                .limit(LOTTO_MAX_SIZE)
                .collect(toList());
        return Collections.unmodifiableList(collect);
    }

    @Override
    public String toString() {
        return getLotto().toString();
    }
}
