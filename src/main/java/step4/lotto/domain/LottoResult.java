package step4.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult   {
    private Map<Rank, Count> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
        initLottoResult();
    }

    public void initLottoResult() {
        for(Rank rank : Rank.values()){
            lottoResult.put(rank, new Count());
        }
    }

    public void plusRankCount(Rank rank){
        lottoResult.get(rank).plus();
    }

    public Count getRankCount(Rank rank) {
        return lottoResult.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}
