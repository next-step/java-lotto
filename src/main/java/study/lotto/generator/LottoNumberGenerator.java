package study.lotto.generator;

import study.lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberGenerator implements NumberGenerator {

    public static final int LOTTO_MAX_SIZE = 6;
    public static final int MAX_NUMBER_BOUND = 45;
    public static final int MIN_NUMBER_BOUND = 1;

    @Override
    public List<LottoNumber> generate(String text) {

        List<LottoNumber> lottoNumbers = createLottoNumbers();
        shuffle(lottoNumbers);

        return readOnlyLottoNumbers(lottoNumbers);
    }

    private List<LottoNumber> createLottoNumbers() {
        return IntStream.range(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    private List<LottoNumber> readOnlyLottoNumbers(final List<LottoNumber> lottoNumbers) {
        List<LottoNumber> collect = lottoNumbers.stream()
                .limit(LOTTO_MAX_SIZE)
                .sorted(LottoNumber::compareTo)
                .collect(toList());
        return Collections.unmodifiableList(collect);
    }

    private void shuffle(final List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }
}
