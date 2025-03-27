package step3.domain;

import java.util.*;

public class LottoNumSet {
    public static final int LOTTO_NUM_COUNT = 6;
    private final Set<LottoNum> lottoNumSet;

    public LottoNumSet(List<LottoNum> lottoNums) {
        validateLottoNums(lottoNums);
        this.lottoNumSet = new HashSet<>(lottoNums);
    }

    private void validateLottoNums(List<LottoNum> lottoNums) {
        if (lottoNums.size() != LOTTO_NUM_COUNT) {
            throw new RuntimeException("로또 숫자는 6개여야합니다.");
        }
        if (new HashSet<>(lottoNums).size() != LOTTO_NUM_COUNT) {
            throw new RuntimeException("로또 숫자는 중복될 수 없습니다.");
        }
    }

    public boolean contains(LottoNum lottoNum) {
        return lottoNumSet.contains(lottoNum);
    }


    public Set<LottoNum> getLottoNumSet() {
        return lottoNumSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumSet that = (LottoNumSet) o;
        return Objects.equals(lottoNumSet, that.lottoNumSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumSet);
    }
}
