package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers fullLottoNumbers() {
        List<LottoNumber> fullLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            fullLottoNumbers.add(new LottoNumber(i));
        }
        return new LottoNumbers(fullLottoNumbers);
    }

    public LottoNumbers randomLottoNumbers() {
        List<LottoNumber> random = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            random.add(lottoNumbers.get(i));
        }
        return new LottoNumbers(random);
    }

    public boolean isSameCount(int count) {
        return lottoNumbers.size() == count;
    }

    public List<LottoNumber> toList() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
