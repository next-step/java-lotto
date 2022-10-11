package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoRankRecord> lottoRankRecords = new ArrayList<>();

    public LottoResult(List<Integer> correctNums) {
        Map<LottoRank, Integer> rankRecord = initilizeRankRecord();
        recordWinRank(correctNums, rankRecord);

        for (LottoRank lottoRank : rankRecord.keySet()) {
            int number = rankRecord.get(lottoRank);
            lottoRankRecords.add(new LottoRankRecord(lottoRank, number));
        }
    }

    public List<LottoRankRecord> getLottoRankRecords() {
        return lottoRankRecords.stream()
                .filter(lottoRankRecord -> lottoRankRecord.isNotRank(LottoRank.NONE))
                .collect(Collectors.toList());
    }

    public double retrieveProfitRatio(int originAmount) {
        double sum = 0;
        for (LottoRankRecord lottoRankRecord : lottoRankRecords) {
            LottoRank rank = lottoRankRecord.getRank();
            int number = lottoRankRecord.getNumber();
            int winPrize = rank.getWinPrize() * number;
            sum += winPrize;
        }
        return getTwoDecimalPointResult(originAmount, sum);
    }

    private static double getTwoDecimalPointResult(int originAmount, double sum) {
        return Math.floor(sum / originAmount * 100) / 100;
    }

    private static List<LottoRank> sortRankByCorrectNum(Map<LottoRank, Integer> rankRecrod) {
        List<LottoRank> ranks = new ArrayList<>(rankRecrod.keySet());
        Collections.sort(ranks, Comparator.comparingInt(LottoRank::getCorrectNum));
        return ranks;
    }

    private static void recordWinRank(List<Integer> correctNums, Map<LottoRank, Integer> rankRecrod) {
        for (Integer winNum : correctNums) {
            LottoRank rank = LottoRank.findRank(winNum);
            insertRank(rankRecrod, rank);
        }
    }

    private static void insertRank(Map<LottoRank, Integer> rankRecrod, LottoRank rank) {
        if (!LottoRank.NONE.equals(rank)) {
            rankRecrod.put(rank, rankRecrod.get(rank) + 1);
        }
    }

    private static Map<LottoRank, Integer> initilizeRankRecord() {
        Map<LottoRank, Integer> rankRecrod = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            rankRecrod.put(lottoRank, 0);
        }
        return rankRecrod;
    }
}
