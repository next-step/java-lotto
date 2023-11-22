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
    public final HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public void purchaseLotto(int money) {
        ValidationCheck.validatePurchaseAmount(money);

        purchaseAmount = money;
        int count = money / LOTTO_PRICE;
        ResultView.printPurchaseCount(count);

        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.buyLottoTicket(count);
        ResultView.printPurchasedLottoNumbers(lottoNumbers.getLottoTicket());
    }

    public void checkLottoWinningNumbers(Buyer buyer, WinningNumbers winningNumbers) {
        for (List<Integer> purchasedList : purchasedLottoNumbers) {
            Rank rank = determineLottoRank(winningNumbers, purchasedList);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        ResultView.showLottoResult(lottoResult, purchaseAmount);
    }

    private int countSameNumber(Set<Integer> winningList, List<Integer> purchasedList) {
        return (int) purchasedList.stream()
                .mapToInt(number -> findSameNumber(winningList, number))
                .sum();
    }

    private int findSameNumber(Set<Integer> winningList, int number) {
        if (winningList.contains(number)) {
            return SAME;
        }
        return NONE;
    }

    private boolean containsBonusNumber(List<Integer> purchasedList, int bonusNumber) {
        return purchasedList.contains(bonusNumber);
    }

    private Rank determineLottoRank(WinningNumbers winningNumbers, List<Integer> purchasedList) {
        int count = countSameNumber(winningNumbers.getWinningNumbers(), purchasedList);
        boolean correctBonusNumber = containsBonusNumber(purchasedList, winningNumbers.getBonusNumber());

        if (count < 3) {
            return Rank.NO_RANK;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getCount() == count)
                .findFirst()
                .map(rank -> (rank == Rank.THIRD && correctBonusNumber) ? Rank.SECOND : rank)
                .orElseThrow();
    }
}
