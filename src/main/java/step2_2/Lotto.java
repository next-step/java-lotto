package step2_2;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private static final List<LottoNumber> RANDOM_LOTTO_NUMBERS;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int ZERO = 0;

    static {
        RANDOM_LOTTO_NUMBERS = IntStream.range(1, 46)
            .mapToObj(LottoNumber::new)
            .collect(toList());
    }

    public static Lotto publish() {
        Collections.shuffle(RANDOM_LOTTO_NUMBERS);
        return new Lotto(RANDOM_LOTTO_NUMBERS.subList(ZERO, LOTTO_NUMBER_SIZE));
    }

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize6(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize6(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberCountMisMatchException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }

}
