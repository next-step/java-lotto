package Lotto;

import java.util.List;

public class ResultView {

    private final String PURCHASE_MUCH = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";

    public void showQuantity(int quantity, ManualLottoCount manualLottoCount) {
        System.out.printf(PURCHASE_MUCH, quantity - manualLottoCount.getManualCount(), manualLottoCount.getManualCount());
    }

    public void showLottoNumbers(LottoBundle lottoBundle) {
        for (int i = 0; i < lottoBundle.getSize(); i++) {
            LottoPaper tempPaper = lottoBundle.getLottoPaper(i);
            lottoNumberShower(tempPaper);
            System.out.println("");
        }
    }

    public void lottoNumberShower(LottoPaper paper) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < paper.getSize() - 1; i++) {
            builder.append(paper.getNumber(i));
            builder.append(",");
        }
        String temp = builder.toString();
        temp = temp.substring(0, temp.length() - 1);
        System.out.print(temp + "]");

    }

    public void showWinner(List<Rank> winners, Amount amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        int[] winnerCount = new int[6];

        for (int i = 0; i < winners.size(); i++) {
            int count = countWinners(winners.get(i));
            winnerCount[count] += 1;
        }

        System.out.println("3개 일치 (5000원) - " + winnerCount[5]+"개");
        System.out.println("4개 일치 (50000원) - " + winnerCount[4]+"개");
        System.out.println("5개 일치 (1500000원) - " + winnerCount[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winnerCount[2] + "개");
        System.out.println("6개 일치 (2000000000원) - " + winnerCount[1]+"개");
        double winPrize = winnerCount[5] *  Rank.FIFTH.getWinningMoney() + winnerCount[4] * Rank.FOURTH.getWinningMoney()
                + winnerCount[3] * Rank.THIRD.getWinningMoney() + winnerCount[2] * Rank.SECOND.getWinningMoney() +
                winnerCount[1] * Rank.FIRST.getWinningMoney();
        double rate = winPrize == 0 ? 0 : Math.round(((winPrize / amount.getAmount()) * 100)/100.0);
        System.out.println("총 수익률은 " + rate + "입니다.");

    }

    private int countWinners(Rank winner) {
        int count = 0;
        if (winner.equals(Rank.FIRST)) {
            count = 1;
        } else if (winner.equals(Rank.SECOND)) {
            count = 2;
        } else if (winner.equals(Rank.THIRD)) {
            count = 3;
        } else if (winner.equals(Rank.FOURTH)) {
            count = 4;
        } else if (winner.equals(Rank.FIFTH)) {
            count = 5;
        }

        return count;
    }
}
