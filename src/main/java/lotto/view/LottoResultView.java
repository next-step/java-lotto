package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoResultView {
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해주세요";
    private static final String BUY_LOTTO_COUNT_GUIDE = "개를 구매했습니다.";
    private static final String WINNER_NUMBER_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNER_STATISTIC_GUIDE = "당첨통계";
    private static final String SEPERATE_GUIDE = "------------------";
    private static final String REVENUE_RATIO_GUIDE_1 = "총 수익률은 ";
    private static final String REVENUE_RATIO_GUIDE_2 = "입니다.(기준이 1이기 때문에 결과적으로 ";
    private static final String REVENUE_RATIO_GUIDE_3 = "라는 의미임)";
    public static final String FIFTH_RANK_GUIDE = "3개 일치 (5000원)- ";
    public static final String FOURTH_RANK_GUIDE = "4개 일치 (50000원)- ";
    public static final String THIRD_RANK_GUIDE = "5개 일치 (1500000원)- ";
    public static final String FIRST_RANK_GUIDE = "6개 일치 (2000000000원)- ";


    public void printPurchaseAmountGuide() {
        printGuideStr(PURCHASE_AMOUNT_GUIDE);
    }

    public int getInputAmout() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printBuyLottoCountGuide(int buyCount) {
        printGuideStr(buyCount + BUY_LOTTO_COUNT_GUIDE);
    }

    public void printPublishLottoNumbers(int buyLottoCount, List<List<Integer>> lottosNumbers) {
        for (int index = 0 ; index < buyLottoCount; index++) {
            List<Integer> numbers = lottosNumbers.get(index);
            printGuideStr("["+String.join(",", strNumbers(numbers))+"]");
        }

    }

    private List<String> strNumbers(List<Integer> numbers) {
        List<String> strNumbers = new ArrayList<>();
        for (int index = 0 ; index < numbers.size(); index++) {
            strNumbers.add(numbers.get(index).toString());
        }
        return strNumbers;
    }

    public void printWinnerNumbersGuide() {
        printGuideStr("");
        printGuideStr(WINNER_NUMBER_GUIDE);
    }

    public String getInputWinnerNumbers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printWinnerStatisticsGuide() {
        printGuideStr("");
        printGuideStr(WINNER_STATISTIC_GUIDE);
        printGuideStr(SEPERATE_GUIDE);
    }

    public void printRankGuide(String rankGuide, int count) {
        printGuideStr(rankGuide+count+"개");
    }

    public void printRevenueRatioGuide(double ratio, String ratioName) {
        printGuideStr(REVENUE_RATIO_GUIDE_1+ratio+REVENUE_RATIO_GUIDE_2+ratioName+REVENUE_RATIO_GUIDE_3);
    }

    private void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }


}
