package automaticlotto.view;

import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String RESULT_TITLE = "당첨 통계\n---------";
    private static final String[] LOTTO_RESULT_SAME = {"3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000원) - ", "6개 일치 (2000000000원) - "};
    private static int totalMoney = 0;

    private OutputView() {

    }

    public static int showLottoNumber(int purchaseAmount) {
        int buyLottoNumbers = buyLottoNumber(purchaseAmount);
        System.out.println(buyLottoNumbers + "개를 구매했습니다.");
        return buyLottoNumbers;
    }

    private static int buyLottoNumber(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static void showBuyingLotto(List<List<String>> buyLotto) {
        for (List<String> lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public static void winningStatistics(String[] winningNumbers, List<List<String>> buyLotto, int purchaseAmount) {
        System.out.println(RESULT_TITLE);
        int[] lottoResult = countWinningNumbers(winningNumbers, buyLotto);
        for (int i = 0; i < lottoResult.length; i++) {
            System.out.println(LOTTO_RESULT_SAME[i] + lottoResult[i] + "개");
        }
        System.out.println(findInterestRate(purchaseAmount));
    }

    private static int[] countWinningNumbers(String[] winningNumbers, List<List<String>> buyLotto) {
        int[] lottoResults = new int[LOTTO_RESULT_SAME.length];
        for (int i = 0; i < buyLotto.size(); i++) {
            int lottoResult = discriminateWinningUnit(winningNumbers, buyLotto.get(i));
            lottoResults = countResultSame(lottoResults, lottoResult);
        }
        return lottoResults;
    }

    private static int discriminateWinningUnit(String[] winningNumbers, List<String> buyLotto) {
        int winningNumberCount = 0;
        for (String winningNumber : winningNumbers) {
            winningNumberCount = buyLotto.contains(winningNumber) ? ++winningNumberCount : winningNumberCount;
        }
        return winningNumberCount;
    }

    private static int[] countResultSame(int[] lottoResults, int lottoResult) {
        if (lottoResult == 3) {
            lottoResults[0]++;
            totalMoney = totalMoney + 5000;
        }
        if (lottoResult == 4) {
            lottoResults[1]++;
            totalMoney = totalMoney + 50000;
        }
        if (lottoResult == 5) {
            lottoResults[2]++;
            totalMoney = totalMoney + 1500000;
        }
        if (lottoResult == 6) {
            lottoResults[3]++;
            totalMoney = totalMoney + 2000000000;
        }
        return lottoResults;
    }

    private static String findInterestRate(int purchaseAmount) {
        double interestRate = (double) totalMoney / purchaseAmount;
        if (interestRate < 1) {
            return "총 수익률은 " + String.format("%.2f", interestRate) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "총 수익률은 " + String.format("%.2f", interestRate) + "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    }
}
