package camp.nextstep.edu.lottery;

public class OutputView {
    public static void printPurchasedLotteries(Lotteries lotteries) {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.count());
        System.out.println(lotteries);
    }

    public static void printResult(Lotteries lotteries, Lottery winningLottery) {
        System.out.print("\n당첨 통계\n---------\n");
        System.out.printf("3개 일치 (5000원)- %d개\n", lotteries.count5thPrize(winningLottery));
        System.out.printf("4개 일치 (50000원)- %d개\n", lotteries.count4thPrize(winningLottery));
        System.out.printf("5개 일치 (1500000원)- %d개\n", lotteries.count3rdPrize(winningLottery));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", lotteries.count1stPrize(winningLottery));
        System.out.printf("총 수익률은 %.2f입니다.", lotteries.calcReturnRate(winningLottery));
    }
}
