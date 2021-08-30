package lotto.domain;

import lotto.LottoConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class LottoResult {
    HashMap<Integer, Integer> lottoResult;

    public LottoResult(List<Integer> sameNumberCounts) {
        lottoResult = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .mapToInt(rank -> rank.getSameNumberCount())
                .forEach(sameNumberCount -> lottoResult.put(sameNumberCount, 0));

        sameNumberCounts.stream()
                .filter(sameNumber -> lottoResult.containsKey(sameNumber))
                .forEach(sameNumber -> lottoResult.put(sameNumber, lottoResult.get(sameNumber) + 1));
    }

    public int getValue(int rank) {
        if (lottoResult.containsKey(rank)) {
            return lottoResult.get(rank);
        }

        throw new RuntimeException(LottoConfig.LOTTO_RESULT_ERROR_MESSAGE);
    }
}
