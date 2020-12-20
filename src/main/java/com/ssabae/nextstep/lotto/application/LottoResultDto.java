package com.ssabae.nextstep.lotto.application;

import com.ssabae.nextstep.lotto.domain.Money;
import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoResultDto {

    private final Map<Integer, Integer> matchCountMap;
    private final int countOfTicket;
    private float earnRate;
    private final Money spendMoney;
    private final Money earnMoney;

    public LottoResultDto(Map<Integer, Integer> matchCountMap, int countOfTicket, float earnRate,
            Money spendMoney, Money earnMoney) {
        this.matchCountMap = matchCountMap;
        this.countOfTicket = countOfTicket;
        this.earnRate = earnRate;
        this.spendMoney = spendMoney;
        this.earnMoney = earnMoney;
    }

    public int getCountOfTicket() {
        return countOfTicket;
    }

    public int getCountByMatchCount(int matchCount) {
        return matchCountMap.getOrDefault(matchCount, 0);
    }

    public float getEarnRate() {
        return earnRate;
    }

    public Money getSpendMoney() {
        return spendMoney;
    }

    public Money getEarnMoney() {
        return earnMoney;
    }


    public static final class LottoResultDtoBuilder {

        private Map<Integer, Integer> matchCountMap;
        private int countOfTicket;
        private float earnRate;
        private Money spendMoney;
        private Money earnMoney;

        private LottoResultDtoBuilder() {
        }

        public static LottoResultDtoBuilder builder() {
            return new LottoResultDtoBuilder();
        }

        public LottoResultDtoBuilder matchCountMap(Map<Integer, Integer> matchCountMap) {
            this.matchCountMap = matchCountMap;
            return this;
        }

        public LottoResultDtoBuilder countOfTicket(int countOfTicket) {
            this.countOfTicket = countOfTicket;
            return this;
        }

        public LottoResultDtoBuilder earnRate(float earnRate) {
            this.earnRate = earnRate;
            return this;
        }

        public LottoResultDtoBuilder spendMoney(Money spendMoney) {
            this.spendMoney = spendMoney;
            return this;
        }

        public LottoResultDtoBuilder earnMoney(Money earnMoney) {
            this.earnMoney = earnMoney;
            return this;
        }

        public LottoResultDto build() {
            return new LottoResultDto(matchCountMap, countOfTicket, earnRate, spendMoney,
                    earnMoney);
        }
    }
}
