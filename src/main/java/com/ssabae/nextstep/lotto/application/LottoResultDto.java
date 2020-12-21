package com.ssabae.nextstep.lotto.application;

import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoResultDto {

    private final Map<Integer, Integer> matchCountMap;
    private final float earnRate;

    public LottoResultDto(Map<Integer, Integer> matchCountMap, float earnRate) {
        this.matchCountMap = matchCountMap;
        this.earnRate = earnRate;
    }

    public int getCountByMatchCount(int matchCount) {
        return matchCountMap.getOrDefault(matchCount, 0);
    }

    public float getEarnRate() {
        return earnRate;
    }


    public static final class LottoResultDtoBuilder {

        private Map<Integer, Integer> matchCountMap;
        private float earnRate;

        private LottoResultDtoBuilder() {
        }

        public static LottoResultDtoBuilder builder() {
            return new LottoResultDtoBuilder();
        }

        public LottoResultDtoBuilder matchCountMap(Map<Integer, Integer> matchCountMap) {
            this.matchCountMap = matchCountMap;
            return this;
        }

        public LottoResultDtoBuilder earnRate(float earnRate) {
            this.earnRate = earnRate;
            return this;
        }

        public LottoResultDto build() {
            return new LottoResultDto(matchCountMap, earnRate);
        }
    }
}
