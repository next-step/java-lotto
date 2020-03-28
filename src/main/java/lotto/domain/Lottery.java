package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottery {

    private List<LottoNumber> lottoNumbers;

    // 테스트를 위해 임시로 기본 생성자 추가
    public Lottery() { }

    public Lottery(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lottery lottery = (Lottery) o;
        return Objects.equals(lottoNumbers, lottery.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
