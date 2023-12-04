package lotto.domain;

import lotto.service.ValidationCheck;
import lotto.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class Buyer {
    public LottoTicket purchasedLottoTicket;
    private static final int LOTTO_PRICE = 1000;
    private static final int SAME = 1;
    private static final int NONE = 0;
    private static int purchaseAmount;
    public final HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public void purchaseLottoTicket(int money) {
        ValidationCheck.validatePurchaseAmount(money);

        purchaseAmount = money;
        int lottoTicketCount = calculateLottoTicketCount(money);
        ResultView.printPurchaseCount(lottoTicketCount);

        LottoTicket lottoTicket = new LottoTicket(lottoTicketCount);
        purchasedLottoTicket = lottoTicket;

        ResultView.printPurchasedLottoNumbers(purchasedLottoTicket);
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public void checkLottoWinningNumbers(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoTicket()) {
            Rank rank = determineLottoRank(winningNumbers, lottoNumbers);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }

        ResultView.showLottoResult(lottoResult, purchaseAmount);
    }

    private Rank determineLottoRank(WinningNumbers winningNumbers, LottoNumbers purchasedList) {
        int count = countMatchingNumbers(winningNumbers.getWinningNumbers(), purchasedList);
        return Rank.getRank(count, purchasedList, winningNumbers.getBonusNumber());
    }

    private int countMatchingNumbers(Set<Integer> winningList, LottoNumbers purchasedList) {
        return (int) purchasedList.getLottoNumbers().stream()
                .mapToInt(lottoNumber -> findSameNumber(winningList, lottoNumber.getNumber()))
                .sum();
    }

    private int findSameNumber(Set<Integer> winningList, int number) {
        if (winningList.contains(number)) {
            return SAME;
        }
        return NONE;
    }

    public static boolean containsBonusNumber(LottoNumbers purchasedList, int bonusNumber) {
        return purchasedList.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList())
                .contains(bonusNumber);
    }
}
