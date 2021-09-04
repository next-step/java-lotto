package step2;

import java.util.*;

public class LottoNumbers {
    private static final int MAXIMUM = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>(MAXIMUM);

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
        Map<LottoNumber, Integer> result = new HashMap<>();
        for (LottoNumber lottoNumber : lottoNumbers.lottoNumbers) {
            if (lottoNumbers.isMatch(lottoNumber)) {
                Integer getLottoNumber = result.getOrDefault(lottoNumber, 0);
                result.put(lottoNumber, getLottoNumber + 1);
            }
        }
        return result.size();
    }

    private boolean isMatch(LottoNumber lottoNumber) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            return true;
        }
        return false;
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
