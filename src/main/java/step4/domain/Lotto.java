package step4.domain;

import java.util.*;

public class Lotto {
    private Set<LottoNumber> lottoNumber;
    public static final int LOTTO_NUMBER = 6;

    public Lotto(Set<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또는 중복을 제거한 6개의 숫자만 가능합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public List<LottoNumber> getLottoNumber() {
        List lottoNumberList = new ArrayList(lottoNumber);
        Collections.sort(lottoNumberList);
        return Collections.unmodifiableList(lottoNumberList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
