package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
        lottoNumbers.stream().sorted().forEach(lottoNumber -> sb.append(lottoNumber.getNumber()).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
