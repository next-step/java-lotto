package com.ssabae.nextstep.lotto.application;

import com.ssabae.nextstep.lotto.domain.Reward;
import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoResultDto {

    private final Map<Reward, Integer> matchCountMap;
    private final float earnRate;

    public LottoResultDto(Map<Reward, Integer> matchCountMap, float earnRate) {
        this.matchCountMap = matchCountMap;
        this.earnRate = earnRate;
    }

    public int getCountByMatchCount(Reward reward) {
        return matchCountMap.getOrDefault(reward, 0);
    }

    public float getEarnRate() {
        return earnRate;
    }


    public static final class LottoResultDtoBuilder {

        private Map<Reward, Integer> matchCountMap;
        private float earnRate;

        private LottoResultDtoBuilder() {
        }

        public static LottoResultDtoBuilder builder() {
            return new LottoResultDtoBuilder();
        }

        public LottoResultDtoBuilder matchCountMap(Map<Reward, Integer> matchCountMap) {
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
