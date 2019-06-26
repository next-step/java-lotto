package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoResultView {
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해주세요";
    private static final String BUY_LOTTO_COUNT_GUIDE = "개를 구매했습니다.";
    private static final String WINNER_NUMBER_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 볼을 입력해 주세요.";
    private static final String WINNER_STATISTIC_GUIDE = "당첨통계";
    private static final String SEPARATE_GUIDE = "------------------";
    private static final String REVENUE_RATIO_GUIDE_1 = "총 수익률은 ";
    private static final String REVENUE_RATIO_GUIDE_2 = "입니다.(기준이 1이기 때문에 결과적으로 ";
    private static final String REVENUE_RATIO_GUIDE_3 = "라는 의미임)";
    private static final String RANK_GUIDE_1 = "개 일치 (";
    private static final String RANK_GUIDE_2 = "원)- ";
    private static final String RANK_GUIDE_3 = "개";


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

    public void printPublishLottoNumbers(List<LottoNumber> lottosNumbers) {
        for (LottoNumber lottoNumber : lottosNumbers) {
            printGuideStr("["+String.join(",", strNumbers(lottoNumber))+"]");
        }
    }

    public List<LottoNumber> getLottosNumbers(List<Lotto> publishLotto) {
        List<LottoNumber> lottosNumbers = new ArrayList<>();
        for (Lotto lotto : publishLotto) {
            lottosNumbers.add(lotto.getLottoNumber());
        }
        return lottosNumbers;
    }

    private List<String> strNumbers(LottoNumber numbers) {
        List<String> strNumbers = new ArrayList<>();
        for (Integer number : numbers.getNumbers()) {
            strNumbers.add(number.toString());
        }
        return strNumbers;
    }

    public void printWinnerNumbersGuide() {
        printGuideStr("");
        printGuideStr(WINNER_NUMBER_GUIDE);
    }

    public void printBonusNumberGuide() {
        printGuideStr(BONUS_NUMBER_GUIDE);
    }

    public String getInputWinnerNumbers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getInputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printWinnerStatisticsGuide() {
        printGuideStr("");
        printGuideStr(WINNER_STATISTIC_GUIDE);
        printGuideStr(SEPARATE_GUIDE);
    }

    public void printRankGuide(Map<Rank, Integer> rankCounts) {
        for (int index = 0; index < Rank.values().length - 1; index++) {
            printGuideStr(Rank.values()[index].getCountOfMatch()
                    +RANK_GUIDE_1
                    +Rank.values()[index].getWinningMoney()
                    +RANK_GUIDE_2
                    +rankCounts.get(Rank.values()[index])
                    +RANK_GUIDE_3);
        }

    }

    public void printRevenueRatioGuide(double ratio, String ratioName) {
        printGuideStr(REVENUE_RATIO_GUIDE_1+ratio+REVENUE_RATIO_GUIDE_2+ratioName+REVENUE_RATIO_GUIDE_3);
    }

    private void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }
}
