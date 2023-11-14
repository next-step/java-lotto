package controller;

import lotto.WinningAmount;
import lotto.type.WinningLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * 당첨 통계 정리용 데이터 클래스
 * 가변 객체입니다.
 */
public class WinningStatistic {
    /**
     * 각 당첨 등수 별로 몇 번 당첨되었는지를 기록하는 테이블(맵)
     */
    private final Map<WinningLevel, Integer> winCountTable = new HashMap<>();

    public WinningStatistic() {
        for (WinningLevel rank : WinningLevel.values()) {
            winCountTable.put(rank, 0);
        }
    }

    /**
     * 당첨 등수의 횟수를 1 올립니다.
     *
     * @param rank 당첨 등수
     */
    public void occurs(WinningLevel rank) {
        int beforeCount = winCountTable.get(rank);
        winCountTable.put(rank, beforeCount + 1);
    }

    /**
     * 주어진 당첨 등수가 몇 번 발생했는지 조회합니다.
     *
     * @param rank 조회할 당첨 등수
     *
     * @return 발생 횟수
     */
    public int getOccurs(WinningLevel rank) {
        return winCountTable.get(rank);
    }

    /**
     * 총 획금 당첨금을 계산합니다.
     *
     * @return 총 당첨금
     */
    public WinningAmount getTotalWinAmount() {
        WinningAmount totalSum = WinningAmount.zero();

        for (WinningLevel rank : WinningLevel.values()) {
            int count = winCountTable.get(rank);
            totalSum = WinningAmount.of(rank).multiply(count).add(totalSum);
        }

        return totalSum;
    }
}