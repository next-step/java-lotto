package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:45
 */
public class Lotto {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        checkValidateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        shuffle();
    }

    private void checkValidateNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }

        if (!lottoNumbers.stream().allMatch(number -> number >= LOTTO_MIN_NUM && number <= LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException("로또는 1부터 45의 숫자로 구성되어야 합니다.");
        }
    }

    private void shuffle() {
        Collections.shuffle(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public Long matchLottoNumberCount(int[] numbers) {
        List<Integer> matchNumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());
        return this.lottoNumbers.stream().filter(number -> matchNumbers.contains(number)).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
