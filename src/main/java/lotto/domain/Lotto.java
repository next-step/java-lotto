package lotto.domain;

import lotto.domain.generator.AutomaticLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.entity.Number;

import java.util.*;

public final class Lotto {

    private final List<Number> lottoNumbers = new ArrayList<>();

    public Lotto(Number... numbers) {
        lottoNumbers.addAll(Arrays.asList(numbers));
        checkValid();
    }

    public Lotto() {
        LottoGenerator automatic = new AutomaticLottoGenerator();
        lottoNumbers.addAll(automatic.numberGenerator());
        checkValid();
    }

    private void checkValid() {
        checkLottoSize();
        checkLottoDuplicateNumbers();
    }

    private void checkLottoSize() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 1장의 숫자는 6개이여야 합니다.");
        }
    }

    private void checkLottoDuplicateNumbers() {
        Set<Number> setNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != setNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 가질수 없습니다.");
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    public Number get(int index) {
        return lottoNumbers.get(index);
    }

    public boolean contains(Number number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return "LottoNumbers=" + lottoNumbers + " } ";
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
