package lotto.domain;

public class LottoResultsService {

    public LottoResult calculateResult(LottoTickets tickets, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket ticket : tickets.getAll()) {
            LottoPrize lottoPrize = winningNumbers.determineLottoPrize(ticket);
            lottoResult.countUp(lottoPrize);
        }
        return lottoResult;
    }
}
