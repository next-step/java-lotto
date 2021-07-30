package lotto.domain;

import lotto.exception.OutOfSizeException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoList implements Iterable<Lotto> {
    private static final List<LottoNumber> NUMBER_TEMPLATE =
            IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());

    private final List<Lotto> values;

    private LottoList(List<Lotto> values) {
        validateValues(values);

        this.values = values;
    }

    public static LottoList generate(Number lottoSize) {
        int size = lottoSize.intValue();

        List<Lotto> newValues = IntStream.range(0, size)
                .mapToObj(i -> new Lotto(randomLottoNumbers()))
                .collect(Collectors.toList());
        return new LottoList(newValues);
    }

    private void validateValues(List<Lotto> values) {
        if (Objects.isNull(values) || values.size() <= 0) {
            throw new OutOfSizeException("0개의 로또를 구매할 수 없습니다.");
        }
    }

    private static synchronized List<LottoNumber> randomLottoNumbers() {
        Collections.shuffle(NUMBER_TEMPLATE);
        return NUMBER_TEMPLATE.subList(0, Lotto.NUMBER_SIZE);
    }

    public LottoStatistics statistics(Lotto prizeLotto) {
        Map<LottoRank, Long> data = this.values.stream().collect(
                Collectors.groupingBy(iLotto -> iLotto.rank(prizeLotto), Collectors.counting())
        );
        return new LottoStatistics(data);
    }

    /* 이하 Forward 메소드들 */
    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return values.iterator();
    }
}
