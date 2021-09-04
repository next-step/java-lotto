package step2;

import java.util.*;

public class LottoNumbers {
    private static final int MAXIMUM = 6;

    private final Set<LottoNumber> lottoNumbers = new HashSet<>(MAXIMUM);

    public LottoNumbers(LottoNumberGenerationStrategy strategy) {
        for (int i = 0; i< MAXIMUM; i++) {
            lottoNumbers.add(new LottoNumber(strategy.generateNumber()));
        }
    }

    public LottoNumbers() {
        this(new LottoNumberAutoGenerationStrategy());
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() > MAXIMUM) {
            throw new RuntimeException("로또 숫자는 최대 6개 입니다.");
        }

        for (int number : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

    public int countNumberOfMatch(LottoNumbers lottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers.lottoNumbers) {
            count += getIfContains(lottoNumber);
        }
        return count;
    }

    private int getIfContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
