package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public int matchLottoNumberCount(List<Integer> winningNumbers) {
        return (int) this.lottoNumbers.stream().filter(number -> winningNumbers.contains(number)).count();
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
