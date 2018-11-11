package view;

import domain.LottoGroup;
import domain.LottoRank;
import domain.WinningLotto;
import domain.WinningLottoGroup;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public static void viewStats() {
        System.out.println("당첨통계");
        System.out.println("---------");
    }

    public static void printResult(double result) {
        System.out.println(String.format("총 수익률은 %1$,.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)", result));
    }

    public static void printBuyLottoCount(int lottoCount) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoCount));
    }

    public static void printLottoGroup(LottoGroup lottoGroup) {
        lottoGroup.getLottoGroup().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printStats(WinningLottoGroup winningLottoGroup) {
        boolean isFiveBonus = true;
        for(LottoRank rank :  LottoRank.values()){
            boolean isBonusCheck = false;
            int lottoCount = winningLottoGroup.getCombineNumbers(rank.getCombineNum(), isBonusCheck);
            if(rank.getCombineNum() == 5 && isFiveBonus){
                lottoCount = winningLottoGroup.getCombineNumbers(rank.getCombineNum(), isFiveBonus);
                isFiveBonus = !isFiveBonus;
                isBonusCheck = !isFiveBonus;
            }
            ResultView.printCombineCurrent(rank.getCombineNum(), isBonusCheck);
            ResultView.printCombineCount(lottoCount);
        }
    }

    public static void printCombineCount(int lottoCount) {
        System.out.println(String.format("- %s개", lottoCount));
    }

    public static void printCombineCurrent(int combineCount, boolean isBonus) {
        System.out.print(String.format("%s개 일치", combineCount ));
        if(combineCount==5 && isBonus) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(String.format(" (%s원)",LottoRank.valueOf(combineCount, isBonus).getPriceRewards()));
    }
}
