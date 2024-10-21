package lotto.view;

import lotto.common.Prize;

public class ResultView {
    private ResultView() {
    }

    public static void printCanBuyLottoCount(int canBuyLottoCount) {
        System.out.println(canBuyLottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lotto) {
        Collections.sort(lotto);

        System.out.println(lotto);
    }

    public static void printWinningStatics(int[] winningStatics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int count = 3; count <= 6; count++) {
            System.out.println(count + "개 일치 (" + Prize.PRIZE[count] + "원)- " + winningStatics[count] + "개");
        }
    }

    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "입니다.");
    }
}
