package lotto.domain;

import lotto.service.ValidationCheck;
import lotto.view.ResultView;

import java.util.*;

public class Buyer {

    public static final List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
    private static final int LOTTO_PRICE = 1000;
    private static final int SAME = 1;
    private static final int NONE = 0;
    private static int purchaseAmount;
    public static final HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public void purchaseLotto(int money) {
        ValidationCheck.validatePurchaseAmount(money);

        purchaseAmount = money;
        int count = money / LOTTO_PRICE;
        ResultView.printPurchaseCount(count);

        for (int i = 0; i < count; i++) {
            LottoNumber lottoNumber = new LottoNumber();
            List<Integer> generatedNumbers = lottoNumber.generateLottoNumbers();
            Collections.sort(generatedNumbers);
            purchasedLottoNumbers.add(generatedNumbers);
        }
    }

    public void checkLottoWinningNumbers(Buyer buyer, WinningNumbers winningNumbers) {
        for (List<Integer> purchasedList : purchasedLottoNumbers) {
            countSameNumber(winningNumbers.getWinningNumbers(), purchasedList);
        }
        showLottoResult();
    }

    private void showLottoResult() {
        long sum = 0;
        ResultView.printWinningStatistics();
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
            ResultView.printWinningResult(rank.getCount(), rank.getPrize(), lottoResult.get(rank));
        }
        double percentage = sum / (double) purchaseAmount;
        ResultView.printProfitPercentage(percentage);
    }

    private void countSameNumber(List<Integer> winningList, List<Integer> purchasedList) {
        int count = NONE;
        for (int number : purchasedList) {
            count += findSameNumber(winningList, number);
        }
        lottoResult.put(Rank.values()[count], lottoResult.getOrDefault(Rank.values()[count], 0) + 1);
    }

    private int findSameNumber(List<Integer> winningList, int number) {
        if (winningList.contains(number)) {
            return SAME;
        }
        return NONE;
    }
}