package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoRankRecord> lottoRankRecords = new ArrayList<>();

    public LottoResult(List<Integer> correctNums) {
        Map<LottoRank, Integer> rankRecrod = new HashMap<>();
        initilizeRankRecord(rankRecrod);
        recordWinRank(correctNums, rankRecrod);

        List<LottoRank> ranks = sortRankByCorrectNum(rankRecrod);
        for (LottoRank lottoRank : ranks) {
            Integer number = rankRecrod.get(lottoRank);
            LottoRankRecord lottoRankRecord = new LottoRankRecord(lottoRank, number);
            lottoRankRecords.add(lottoRankRecord);
        }
    }

    public List<LottoRankRecord> getLottoRankRecords() {
        return lottoRankRecords.stream()
                .filter(lottoRankRecord -> lottoRankRecord.isNotRank(LottoRank.NONE))
                .collect(Collectors.toList());
    }

    public float retrieveProfitRatio(int originAmount) {
        float sum = 0;
        for (LottoRankRecord lottoRankRecord : lottoRankRecords) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            if (LottoRank.NONE.equals(rank)) {
                continue;
            }

            int winPrize = rank.getWinPrize() * number;
            sum += winPrize;
        }
        return sum / originAmount;
    }

    private static List<LottoRank> sortRankByCorrectNum(Map<LottoRank, Integer> rankRecrod) {
        List<LottoRank> ranks = new ArrayList<>(rankRecrod.keySet());
        Collections.sort(ranks, Comparator.comparingInt(LottoRank::getCorrectNum));
        return ranks;
    }

    private static void recordWinRank(List<Integer> correctNums, Map<LottoRank, Integer> rankRecrod) {
        for (Integer winNum : correctNums) {
            LottoRank rank = LottoRank.findRank(winNum);
            rankRecrod.put(rank, rankRecrod.get(rank) + 1);
        }
    }

    private static void initilizeRankRecord(Map<LottoRank, Integer> rankRecrod) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankRecrod.put(lottoRank, 0);
        }
    }
}
