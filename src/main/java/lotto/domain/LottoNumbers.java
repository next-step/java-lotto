package lotto.domain;

import java.util.Set;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() > 6) {
            throw new IllegalArgumentException("당첨 번호는 6개 이하입니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public int match(LottoNumbers lottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers.lottoNumbers) {
            count = addCount(count, lottoNumber);
        }
        return count;
    }

    private int addCount(int count, LottoNumber lottoNumber) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }

    public static int getPrize(int match) {
        if (match == 3) {
            return 5000;
        }
        if (match == 4) {
            return 50000;
        }
        if (match == 5) {
            return 1500000;
        }
        if (match == 6) {
            return 2000000000;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;

        LottoNumbers that = (LottoNumbers) o;
        return that.lottoNumbers.containsAll(lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            sb.append(lottoNumber.getNumber()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
