package kr.insup.lotto.view;

import kr.insup.lotto.domain.Lotto;
import kr.insup.lotto.domain.Lottos;
import kr.insup.lotto.domain.Place;
import kr.insup.lotto.domain.Statistics;

import java.util.Scanner;

public class LottoView {

    private static Scanner scanner = new Scanner(System.in);

    public static Integer getPrice() {
        System.out.println("구입 금액을 입력해 주세요");

        String strPrice = scanner.nextLine();
        return Integer.valueOf(strPrice);
    }

    public static void showPurchase(int attempt) {
        System.out.println(attempt + "개를 구매했습니다.");
    }

    public static void showLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.lottoList()) {
            String numbers = String.join(",", lotto.numbers());
            System.out.println("[" + numbers + "]");
        }
    }

    public static String showWinningNumber() {
        System.out.println("지난 주 당첨번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public static void showWinningStatistic(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        announceWinningStatus(1, Place.First.match(), Place.First.winnings(), statistics.firstPlace());
        announceWinningStatus(2, Place.Second.match(), Place.Second.winnings(), statistics.secondPlace());
        announceWinningStatus(3, Place.Third.match(), Place.Third.winnings(), statistics.thirdPlace());
        announceWinningStatus(4, Place.Fourth.match(), Place.Fourth.winnings(), statistics.fourthPlace());
        System.out.println("수익률은 " + statistics.calculateBenefitRate());
    }

    private static void announceWinningStatus(int rank, int match, int price, int time) {
        System.out.println(rank + "등 " + match + "개 일치 (" + price + "원) - " + time + "개");
    }

    public static void printIllegalArgument() {
        System.out.println("잘못된 당첨번호를 입력하였습니다. 다시 입력해주세요!");
    }

    public static void printWrongNumberFormat() {
        System.out.println("잘못된 금액을 입력하였습니다. 다시 입력해주세요!");
    }
}
