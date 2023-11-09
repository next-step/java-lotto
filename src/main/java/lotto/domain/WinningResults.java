package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class WinningResults {

    public static final int DEFAULT_VALUE = 0;
    private final Map<LottoRank, Integer> values;

    public WinningResults(WinningLottoNumber winningLottoNumber,
                          List<LottoNumber> lottoNumbers) {
        Map<LottoRank, Integer> treeMap = new TreeMap<>();
        for(LottoRank lottoRank : LottoRank.values()) {
            treeMap.put(lottoRank, DEFAULT_VALUE);
        }
        this.values = treeMap;

        for (LottoNumber lottoNumber : lottoNumbers) {
            LottoRank lottoRank = winningLottoNumber.winningRank(lottoNumber);
            values.put(lottoRank, createValue(lottoRank));
        }
    }

    public WinningResults(Map<LottoRank, Integer> lottoRankIntegerMap) {
        this.values = lottoRankIntegerMap;
    }

    public int size() {
        return values.size();
    }

    private int createValue(LottoRank lottoRank) {
        return values.getOrDefault(lottoRank, DEFAULT_VALUE) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResults that = (WinningResults) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
