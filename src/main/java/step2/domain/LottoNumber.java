package step2.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> LottoNumber) {
        this.lottoNumber = LottoNumber;
    }

    public int compareMatch(LottoNumber lottoNumber) {
        return (int) lottoNumber.getLottoNumber().stream()
                .filter(this.lottoNumber::contains)
                .count();
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
