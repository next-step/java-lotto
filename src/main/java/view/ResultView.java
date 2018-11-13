package view;

import domain.*;

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
        lottoGroup.getLottoGroup().forEach((lotto)-> System.out.println(lotto.toString()));
    }

    public static void printStats(LottoResultGroup lottoResultGroup) {
        for(LottoRank rank :  LottoRank.values()){
            int lottoCount = lottoResultGroup.getCombineNumbers(rank);
            ResultView.printCombineCurrent(rank);
            ResultView.printCombineCount(lottoCount);
        }
    }

    public static void printCombineCount(int lottoCount) {
        System.out.println(String.format("- %s개", lottoCount));
    }

    public static void printCombineCurrent(LottoRank rank) {
        System.out.print(String.format("%s개 일치", rank.getCombineNum() ));
        if(rank.equals(LottoRank.SECOND_PRICE)) {
            System.out.print(", 보너스 볼 일치");
        }
        printRewards(rank);
    }

    private static void printRewards(LottoRank rank) {
        System.out.print(String.format(" (%s원)", rank.getPriceRewards()));
    }
}
