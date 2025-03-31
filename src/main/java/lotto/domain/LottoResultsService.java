package lotto.domain;

public class LottoResultsService {

    public LottoResult calculateResult(LottoTickets tickets, WinningNumbers winningNumbers, int bonusNumber, int purchaseAmount) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket ticket : tickets.getAll()) {
            LottoPrize lottoPrize = winningNumbers.determineLottoPrize(ticket);
            lottoResult.update(lottoPrize);
        }
        lottoResult.calculateProfitRate(purchaseAmount);
        return lottoResult;
    }
}
