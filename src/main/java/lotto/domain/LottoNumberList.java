package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumberList {

    private final List<LottoNumber> lottoNumberList;
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 6개여야 합니다.";
    private static final String LOTTO_NUMBER_OVERLAP_EXCEPTION = "로또 번호는 중복 될 수 없습니다.";

    public static LottoNumberList getLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : Numbers.getSixNumbers()) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumberList(lottoNumbers);
    }

    public LottoNumberList(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        if (isOverlap(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVERLAP_EXCEPTION);
        }
        this.lottoNumberList = lottoNumbers;
    }

    private boolean isOverlap(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            return true;
        }
        return false;
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
