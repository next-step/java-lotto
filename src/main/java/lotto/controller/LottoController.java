package lotto.controller;

import lotto.domain.*;
import lotto.domain.Dto.RankCountDto;
import lotto.enums.WinningRank;
import lotto.utils.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        LottoTickets lottoTickets = createLottoTickets(purchaseAmount);
        resultView.printLottoNumbers(lottoTickets);

        WinningNumbers winningNumbers = createWinningNumbers();
        RanksCount ranksCount = matchWith(winningNumbers, lottoTickets);
        resultView.printStatistics(createRanksCountDtos(ranksCount));

        printProfitRate(new ProfitRate(ranksCount.totalPrize(), purchaseAmount));
    }

    private RanksCount matchWith(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        RanksCount ranksCount = new RanksCount();

        for (LottoTicket lottoTicket : lottoTickets.lottoTickets()) {
            WinningRank winningRank = winningNumbers.matchWith(lottoTicket);
            ranksCount.add(winningRank);
        }

        return ranksCount;
    }

    protected PurchaseAmount createPurchaseAmount() {
        String purchaseAmount = inputView.purchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    protected LottoTickets createLottoTickets(PurchaseAmount purchaseAmount) {
        LottoTicketPrice lottoTicketPrice = new LottoTicketPrice();

        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(purchaseAmount, lottoTicketPrice);
        ManualNumberOfTicket manualNumberOfTicket = manualNumberOfTicket(totalNumberOfTicket);
        AutoNumberOfTicket autoNumberOfTicket = new AutoNumberOfTicket(manualNumberOfTicket, totalNumberOfTicket);

        LottoTickets manualLottoTickets = createManualLottoTickets(manualNumberOfTicket);
        LottoTickets autoLottoTickets = createAutoLottoTickets(totalNumberOfTicket, manualNumberOfTicket);
        resultView.purchaseTickets(manualNumberOfTicket.numberOfTicket(), autoNumberOfTicket.numberOfTicket());

        return new LottoTickets(manualLottoTickets, autoLottoTickets);
    }

    private ManualNumberOfTicket manualNumberOfTicket(TotalNumberOfTicket totalNumberOfTicket) {
        return new ManualNumberOfTicket(inputView.manualLottoTicketCount(), totalNumberOfTicket);
    }

    private LottoTickets createManualLottoTickets(ManualNumberOfTicket manualNumberOfTicket) {
        inputView.manualLottoNumberPhrase();
        List<String> manualLottoTickets = inputView.manualLottoNumbers(manualNumberOfTicket.numberOfTicket());

        return LottoTickets.createBy(manualLottoTickets);
    }

    private LottoTickets createAutoLottoTickets(TotalNumberOfTicket totalNumberOfTicket, ManualNumberOfTicket manualNumberOfTicket) {
        return LottoTickets.createBy(totalNumberOfTicket.minus(manualNumberOfTicket));
    }

    protected WinningNumbers createWinningNumbers() {
        LottoNumbers winningNumbers = LottoNumbers.from(SplitUtil.splitByComma(inputView.winningNumbers()));
        BonusBall bonusBall = new BonusBall(LottoNumber.of(inputView.bonusBall()));
        return new WinningNumbers(bonusBall, winningNumbers);
    }

    protected List<RankCountDto> createRanksCountDtos(RanksCount ranksCount) {
        List<RankCountDto> rankCountDtos = new ArrayList<>();

        for (Map.Entry<WinningRank, Integer> rank : ranksCount.entrySet()) {
            RankCountDto rankCountDto = new RankCountDto(rank.getKey(), rank.getValue());
            rankCountDtos.add(rankCountDto);
        }

        return rankCountDtos;
    }

    protected void printProfitRate(ProfitRate profitRate) {
        if (profitRate.isPositive()) {
            resultView.printPositiveProfitRate(profitRate.profitRate());
        }

        if (!profitRate.isPositive()) {
            resultView.printNegativeProfitRate(profitRate.profitRate());
        }
    }
}
