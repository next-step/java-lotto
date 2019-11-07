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

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        shuffle();
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
