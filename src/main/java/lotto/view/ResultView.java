package lotto.view;


import lotto.domain.Winner;

public class ResultView {
    private final static String PURCHASE_PRINT_DESCRIPTION = "개를 구매했습니다.";
    public static void purchaseCountPrint(final int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_PRINT_DESCRIPTION);
    }

    public static void print(final String text) {
        System.out.println(text);
    }

    public static void winnerPrint(final Winner winner) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n---------\n");
        stringBuilder.append(String.format("3개 일치 (5000원)- %d개\n", winner.getWinnerCount(3)));
        stringBuilder.append(String.format("4개 일치 (50000원)- %d개\n", winner.getWinnerCount(4)));
        stringBuilder.append(String.format("5개 일치 (1500000원)- %d개\n", winner.getWinnerCount(5)));
        stringBuilder.append(String.format("6개 일치 (2000000000원)- %d개\n", winner.getWinnerCount(6)));

        System.out.println(stringBuilder.toString());
    }
}
