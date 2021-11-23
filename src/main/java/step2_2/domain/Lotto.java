package step2_2.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {

    private static final List<LottoNumber> RANDOM_LOTTO_NUMBERS = initDefaultLottoNumbers();
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int ZERO = 0;

    public static Lotto publish() {
        Collections.shuffle(RANDOM_LOTTO_NUMBERS);
        List<LottoNumber> randomNumbers = RANDOM_LOTTO_NUMBERS.subList(ZERO, LOTTO_NUMBER_SIZE);
        return new Lotto(new ArrayList<>(randomNumbers));
    }

    private static List<LottoNumber> initDefaultLottoNumbers() {
        return IntStream.range(1, 46)
            .mapToObj(LottoNumber::new)
            .collect(toList());
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

    public LottoReward getReward(Lotto winner) {
        long matchCount = lottoNumbers.stream()
            .filter(winner::containsLottoNumber)
            .count();

        return LottoReward.fromMatchCount(matchCount);
    }

    private boolean containsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Lotto.class)) {
            return false;
        }
        Lotto other = (Lotto) o;
        return lottoNumbers.containsAll(other.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
