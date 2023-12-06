package lotto.domain;

import lotto.service.ValidationCheck;
import lotto.view.InputView;
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

    public void purchaseLottoTicket(int money, int manualPurchaseCount) {
        ValidationCheck.validatePurchaseAmount(money);
        List<String> manualNumbers = InputView.inputManualNumbers(manualPurchaseCount);

        purchaseAmount = money;
        int lottoTicketCount = calculateLottoTicketCount(money);
        int autoTicketCount = lottoTicketCount - manualPurchaseCount;
        ResultView.printPurchaseCount(autoTicketCount, manualPurchaseCount);

        LottoTicket lottoAutoTicket = new LottoTicket(autoTicketCount);

        purchasedLottoTicket = LottoTicket.mergeLottoTicket(lottoAutoTicket, manualNumbers);

        for(LottoNumbers lottoNumbers : purchasedLottoTicket.getLottoTicket()) {
            ResultView.printPurchasedLottoNumbers(numbersToList(lottoNumbers.getLottoNumbers()));
        }
    }

    private static List<Integer> numbersToList(Set<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public void checkLottoWinningNumbers(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        long sum = 0;
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoTicket()) {
            Rank rank = determineLottoRank(winningNumbers, lottoNumbers);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        ResultView.printWinningStatistics();
        for(Rank rank : lottoResult.keySet()) {
            sum+= rank.getPrize() * lottoResult.get(rank);
            ResultView.printWinningResult(rank, lottoResult.get(rank));
        }
        double percentage = sum / (double) purchaseAmount;
        ResultView.printProfitPercentage(percentage);
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
