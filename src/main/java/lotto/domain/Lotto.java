package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;
    private boolean isManual;

    public Lotto() {
        List<LottoNumber> candidates = new ArrayList<>(LottoNumber.values());
        Collections.shuffle(candidates);

        this.lottoNumbers = new HashSet<>(candidates.subList(0, LOTTO_SIZE));
        this.isManual = false;
    }

    public Lotto(List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = new HashSet<>(lottoNumbers);

        if (this.lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("HAS UNIQUE " + LOTTO_SIZE + " LOTTO NUMBERS");
        }

        this.isManual = true;
    }

    public Lotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
            .map(number -> LottoNumber.valueOf(number.trim()))
            .collect(Collectors.toList());

        this.lottoNumbers = new HashSet<>(lottoNumbers);
        this.isManual = true;

        new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(Lotto anyLotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(this.lottoNumbers);
        Set<LottoNumber> anyLottoNumbers = new HashSet<>(anyLotto.lottoNumbers);

        lottoNumbers.retainAll(anyLottoNumbers);

        return lottoNumbers.size();
    }

    public boolean isManual() {
        return isManual;
    }

    public boolean isAuto() {
        return !isManual;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
