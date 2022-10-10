package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumberList {

    private final List<LottoNumber> lottoNumberList;
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 6개여야 합니다.";

    public LottoNumberList(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        this.lottoNumberList = lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberList that = (LottoNumberList) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
