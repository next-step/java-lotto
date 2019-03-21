package lotto.domain;

import lotto.LottoRandomNumberGenerator;

import java.util.*;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.publish();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<LottoNumber> publish() {
        Set<LottoNumber> numbers = new HashSet<>(LOTTO_SIZE);

        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(LottoRandomNumberGenerator.next());
        }

        this.lottoNumbers = new ArrayList<>(numbers);
        Collections.shuffle(this.lottoNumbers);

        return this.lottoNumbers;
    }

    public int getContainsCount(final Lotto winningLotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(this.lottoNumbers);
        Set<LottoNumber> winningNumbers = new HashSet<>(winningLotto.getLottoNumbers());

        lottoNumbers.retainAll(winningNumbers);

        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
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
