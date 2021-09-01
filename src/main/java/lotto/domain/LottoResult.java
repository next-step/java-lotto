package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class LottoResult {
    public static final String LOTTO_RESULT_ERROR_MESSAGE = "잘못된 등수값을 입력받았습니다.";

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

        throw new RuntimeException(LOTTO_RESULT_ERROR_MESSAGE);
    }
}
