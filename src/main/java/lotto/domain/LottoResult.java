package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoResult {

    private static final long LOTTO_AMOUNT = 1000;
    private int totalLottoCnt;
    private int totalPrize;
    private int fourthPlaceCnt;
    private int thirdPlaceCnt;
    private int secondPlaceCnt;
    private int firstPlaceCnt;
    private double profitPercent;

    public LottoResult(Lottos lottos) {
        this.totalLottoCnt = lottos.lottos.size();
        this.firstPlaceCnt = 0;
        this.secondPlaceCnt = 0;
        this.thirdPlaceCnt = 0;
        this.fourthPlaceCnt = 0;
        calculatePalceCnt(lottos);
        this.profitPercent = totalPrize/(totalLottoCnt * LOTTO_AMOUNT);
    }

    private void calculatePalceCnt(Lottos lottos) {
        ArrayList<Rank> rankList = lottos.getRankList();
        rankList.stream().forEach(rank -> calculatePalceCnt(rank));
    }

    private void calculatePalceCnt(Rank rank) {
        if(Rank.FirstPlace.equals(rank)) {
            this.totalPrize += Rank.FirstPlace.getWinnings();
            this.firstPlaceCnt++;
        }
        if(Rank.SecondPlace.equals(rank)) {
            this.totalPrize += Rank.SecondPlace.getWinnings();
            this.secondPlaceCnt++;
        }
        if(Rank.ThirdPlace.equals(rank)) {
            this.totalPrize += Rank.ThirdPlace.getWinnings();
            this.thirdPlaceCnt++;
        }
        if(Rank.FourthPlace.equals(rank)) {
            this.totalPrize += Rank.FourthPlace.getWinnings();
            this.fourthPlaceCnt++;
        }
    }

    public static LottoResult create(Lottos lottos) {
        return new LottoResult(lottos);
    }

    public ArrayList<Integer> getPlaceCnt() {
        return new ArrayList(Arrays.asList(firstPlaceCnt, secondPlaceCnt, thirdPlaceCnt, fourthPlaceCnt));
    }

    public double getProfitPercent() {
        return this.profitPercent;
    }
}
