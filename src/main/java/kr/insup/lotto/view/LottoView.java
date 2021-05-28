package kr.insup.lotto.view;

import kr.insup.lotto.domain.*;
import kr.insup.lotto.utils.LottoNumberParser;

import java.util.*;

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

    public static Integer getManualLottoCount() {
        System.out.println("수동으로 구매할 개수를 입력해주세요.");

        String strManualCount = scanner.nextLine();

        return Integer.valueOf(strManualCount);
    }

    public static List<String> getManualLotto(int manualCount) {

        System.out.println("수동으로 구매할 번호를 입력해주세요");

        List<String> manualLotto = new ArrayList<>();

        for (int i = 0; i < manualCount; i++) {
            System.out.println((i + 1) + "번째 번호 : ");
            String strManualLotto = scanner.nextLine();
            manualLotto.add(strManualLotto);
        }

        return manualLotto;
    }

    public static void showLottoList(Lottos lottos, int autoCount, int manualCount) {
        System.out.println("자동으로 " + autoCount + "장, 수동으로 " + manualCount + "장 구입하였습니다");

        for (Lotto lotto : lottos.lottoList()) {
            List<String> lottoList = convertNumbersToList(lotto.numbers());
            String numbers = String.join(",", lottoList);
            System.out.println("[" + numbers + "]");
        }
    }

    private static List<String> convertNumbersToList(Set<LottoNumber> numbers) {
        List<String> numberList = new ArrayList<>();

        for (LottoNumber number : numbers) {
            numberList.add(String.valueOf(number.number()));
        }

        Collections.sort(numberList, Comparator.comparing(Integer::valueOf));

        return new ArrayList<>(numberList);
    }

    public static String showWinningNumber() {
        System.out.println("지난 주 당첨번호를 입력해 주세요");

        return scanner.nextLine();
    }

    public static Integer showBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumberStr = scanner.nextLine();
        return Integer.valueOf(bonusNumberStr);
    }

    public static void showWinningStatistic(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        announceWinningStatus(1, LottoPrize.First.match(), LottoPrize.First.winnings(), statistics.firstPlace());
        announceWinningStatusOnlySecond(2, LottoPrize.Second.match(), LottoPrize.Second.winnings(), statistics.secondPlace());
        announceWinningStatus(3, LottoPrize.Third.match(), LottoPrize.Third.winnings(), statistics.thirdPlace());
        announceWinningStatus(4, LottoPrize.Fourth.match(), LottoPrize.Fourth.winnings(), statistics.fourthPlace());
        announceWinningStatus(5, LottoPrize.Fifth.match(), LottoPrize.Fifth.winnings(), statistics.fifthPlace());
        System.out.println("수익률은 " + statistics.calculateBenefitRate());
    }

    private static void announceWinningStatus(int rank, int match, int price, int time) {
        System.out.println(rank + "등 " + match + "개 일치 (" + price + "원) - " + time + "개");
    }

    private static void announceWinningStatusOnlySecond(int rank, int match, int price, int time) {
        System.out.println(rank + "등 " + match + "개 일치 + 보너스 번호 (" + price + "원) - " + time + "개");
    }

    public static void printIllegalArgument(String errorMessage) {
        System.out.println(errorMessage + " 다시 입력해주세요!");
    }

    public static void printWrongWinningNumberFormat() {
        System.out.println("숫자가 아닌 당첨번호를 입력하였습니다. 다시 입력해주세요!");
    }

    public static void printWrongPriceFormat() {
        System.out.println("숫자가 아닌 금액을 입력하였습니다. 다시 입력해주세요!");
    }

    public static void printWrongManualNumberFormat() {
        System.out.println("숫자가 아닌 번호를 입력하였습니다. 다시 입력해주세요!");
    }

    public static void printWrongManualCount() {
        System.out.println("수동 게임의 숫자가 전체 게임 수보다 많습니다. 다시 입력해주세요!");
    }
}
