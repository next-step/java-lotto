package lotto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRecord {
    private static final String REMARK = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private final Map<LottoRank, Integer> lottoRecord;

    private double profit = 0;

    public LottoRecord() {
        this.lottoRecord = new LinkedHashMap<>();
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.isMiss())
                .forEach(lottoRank -> lottoRecord.put(lottoRank, 0));
    }

    public void recordRank(LottoRank lottoRank) {
        if (lottoRank.isMiss()) {
            return;
        }
        lottoRecord.put(lottoRank, lottoRecord.get(lottoRank) + 1);
    }

    public boolean isRecord(LottoRank lottoRank, int expected) {
        return lottoRecord.get(lottoRank) == expected;
    }

    public void printResult() {
        for (LottoRank lottoRank : lottoRecord.keySet()) {
            lottoRank.printReward(lottoRecord.get(lottoRank));
        }
        System.out.printf(REMARK, profit);
    }

    public void calculateProfit(int lottoCount) {
        int sumReward = 0;
        for (LottoRank lottoRank : lottoRecord.keySet()) {
            sumReward += lottoRank.rankOfReward(lottoRecord.get(lottoRank));
        }
        if(sumReward != 0){
            profit = Math.floor((double) sumReward / (lottoCount * LottoValidationUtils.LOTTO_COST) * 100) / 100;
        }
    }

    public boolean isProfit(double expected){
        return profit == expected;
    }
}
