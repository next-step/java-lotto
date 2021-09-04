package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private static final int MAXIMUM = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>(MAXIMUM);

    public LottoNumbers(LottoNumberGenerationStrategy strategy) {
        for (int i = 0; i< MAXIMUM; i++) {
            lottoNumbers.add(new LottoNumber(strategy.generateNumber()));
        }
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() > MAXIMUM) {
            throw new RuntimeException("로또 숫자는 최대 6개 입니다.");
        }

        for (int number : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
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
