package lotto;

import lotto.domain.*;
import lotto.domain.Dto.RankCountDto;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        LottoTickets lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = createWinningNumbers();
        BonusBall bonusBall = createBonusBall(winningNumbers);
        RanksCount ranksCount = createRanksCount(winningNumbers, lottoTickets);
        matchWith(ranksCount, bonusBall);
        printStatistics(createRanksCountDto(ranksCount));
        ProfitRate profitRate = createProfitRate(ranksCount, purchaseAmount);
        printProfitRate(profitRate);
    }

    private static PurchaseAmount createPurchaseAmount() {
        try {
            String purchaseAmount = InputView.purchaseAmount();
            return new PurchaseAmount(purchaseAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createPurchaseAmount();
        }
    }

    private static LottoTickets createLottoTickets(PurchaseAmount purchaseAmount) {
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();
        TicketOffice ticketOffice = new TicketOffice(lottoTicketPrice);
        NumberOfTicket numberOfTicket = new NumberOfTicket(purchaseAmount, lottoTicketPrice);
        ResultView.purchaseTickets(numberOfTicket.numberOfTicket());
        return ticketOffice.sale(numberOfTicket);
    }

    private static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            ResultView.lottoNumbers(lottoTicket.lottoNumbers());
        }
    }

    private static WinningNumbers createWinningNumbers() {
        try {
            List<String> winningNumbers = SplitUtil.splitByComma(InputView.winningNumbers());
            return WinningNumbers.from(winningNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createWinningNumbers();
        }
    }

    private static BonusBall createBonusBall(WinningNumbers winningNumbers) {
        try {
            LottoNumber bonusNumber = new LottoNumber(InputView.bonusBall());
            winningNumbers.check(bonusNumber);
            return new BonusBall(bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createBonusBall(winningNumbers);
        }
    }

    private static RanksCount createRanksCount(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        RanksCount ranksCount = new RanksCount(winningNumbers, lottoTickets);
        return ranksCount;
    }

    private static void matchWith(RanksCount ranksCount, BonusBall bonusBall) {
        ranksCount.count(bonusBall);
    }

    private static List<RankCountDto> createRanksCountDto(RanksCount ranksCount) {
        return ranksCount.dtos();
    }

    private static void printStatistics(List<RankCountDto> ranksCount) {
        ResultView.statistics(ranksCount);
    }

    private static ProfitRate createProfitRate(RanksCount ranksCount, PurchaseAmount purchaseAmount) {
        return new ProfitRate(ranksCount.totalPrize(), purchaseAmount);
    }

    private static void printProfitRate(ProfitRate profitRate) {
        if (profitRate.isPositive()) {
            ResultView.positiveProfitRate(profitRate.profitRate());
        }

        if (!profitRate.isPositive()) {
            ResultView.negativeProfitRate(profitRate.profitRate());
        }
    }
}
