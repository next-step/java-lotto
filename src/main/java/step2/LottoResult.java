package step2;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> lottoResultMap;

    public LottoResult(Map<LottoRank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public static LottoResult from(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> resultMap = new EnumMap<LottoRank, Integer>(LottoRank.class);

        for (LottoRank rank : lottoRanks) {

        }
    }
}
