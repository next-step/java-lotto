package lotto.domain;

import java.util.*;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    static {
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            LOTTO_NUMBERS.add(LottoNumber.of(i));
        }
    }

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);

        lottoNumbers = new HashSet<>(LOTTO_NUMBERS.subList(0, LOTTO_SIZE));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = new HashSet<>(lottoNumbers);

        if (this.lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("HAS UNIQUE " + LOTTO_SIZE + " LOTTO NUMBERS");
        }
    }

    public Lotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            lottoNumbers.add(LottoNumber.of(numbers[i]));
        }

        this.lottoNumbers = new HashSet<>(lottoNumbers);
        new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(Lotto anyLotto) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            count = this.countMatches(anyLotto, count, lottoNumber);
        }

        return count;
    }

    private int countMatches(Lotto anyLotto, int count, LottoNumber lottoNumber) {
        if (anyLotto.contains(lottoNumber)) {
            count++;
        }

        return count;
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
