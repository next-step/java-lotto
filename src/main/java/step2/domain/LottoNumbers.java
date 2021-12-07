package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN_INDEX = 0;
    private static final int LOTTO_NUMBER_MAX_INDEX = LOTTO_NUMBER_TOTAL_COUNT - 1;
    private static final List<LottoNumber> NUMBERS = IntStream
            .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(toList());

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generate() {
        List<LottoNumber> copyOfNumbers = new ArrayList<>(NUMBERS);
        Collections.shuffle(copyOfNumbers);
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX)
                .mapToObj(copyOfNumbers::get)
                .sorted()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return new LottoNumbers(lottoNumbers);
    }

    public int numberOfMatching(LottoWinningNumbers lottoWinningNumbers) {
        int numberOfMatching = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            numberOfMatching += lottoWinningNumbers.numberOfMatching(lottoNumber);

        }
        return numberOfMatching;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
