package com.ssabae.nextstep.lotto.domain;

import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoResult {

    private final Map<Integer, Integer> matchCountMap;
    private final Money spendMoney;
    private final Money earnMoney;

    public LottoResult(Map<Integer, Integer> matchCountMap,
            Money spendMoney, Money earnMoney) {
        this.matchCountMap = matchCountMap;
        this.spendMoney = spendMoney;
        this.earnMoney = earnMoney;
    }

    public float calculateEarnRate() {
        return (float) earnMoney.getAmountLongValue() / spendMoney.getAmountLongValue();
    }

    public Map<Integer, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public static final class LottoResultBuilder {

        private Map<Integer, Integer> matchCountMap;
        private Money spendMoney;
        private Money earnMoney;

        private LottoResultBuilder() {
        }

        public static LottoResultBuilder builder() {
            return new LottoResultBuilder();
        }

        public LottoResultBuilder matchCountMap(Map<Integer, Integer> matchCountMap) {
            this.matchCountMap = matchCountMap;
            return this;
        }

        public LottoResultBuilder spendMoney(Money spendMoney) {
            this.spendMoney = spendMoney;
            return this;
        }

        public LottoResultBuilder earnMoney(Money earnMoney) {
            this.earnMoney = earnMoney;
            return this;
        }

        public LottoResult build() {
            return new LottoResult(matchCountMap, spendMoney, earnMoney);
        }
    }
}
