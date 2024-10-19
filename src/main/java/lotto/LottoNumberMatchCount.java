package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumberMatchCount {
    List<Integer> lottoNumberMatchCountList;

    public LottoNumberMatchCount(List<Integer> lottoNumberMatchCountList) {
        this.lottoNumberMatchCountList = lottoNumberMatchCountList;
    }

    public void updateMatchingCount(int matchingCountIndex) {
        int countValue = lottoNumberMatchCountList.get(matchingCountIndex);
        lottoNumberMatchCountList.set(matchingCountIndex, countValue + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberMatchCount that = (LottoNumberMatchCount) o;
        return Objects.equals(lottoNumberMatchCountList, that.lottoNumberMatchCountList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumberMatchCountList);
    }
}
