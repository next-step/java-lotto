package service;

import domain.Currency;
import domain.Lotto;
import repository.LottoGameResultRepository;
import domain.LottoPrize;
import repository.UserLottoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoResultService {

    private final UserLottoRepository userLottoRepository;

    public LottoResultService(UserLottoRepository userLottoRepository) {
        this.userLottoRepository = userLottoRepository;
    }

    public LottoGameResultRepository matchUserLotto(Lotto winningLotto) {
        LottoGameResultRepository lottoMatchResult = new LottoGameResultRepository();
        List<Lotto> lottoTickets = userLottoRepository.getUserLottoTickets();

        int matchCount = 0;
        for (Lotto lottoTicket : lottoTickets) {
            matchCount = lottoTicket.calculateMatchCount(winningLotto);
            lottoMatchResult.saveResult(getPrize(matchCount));
        }
        return lottoMatchResult;
    }

    private static LottoPrize getPrize(int matchCount) {
        return LottoPrize.fromMatchCount(matchCount);
    }

    public float calculateReturnRate(long money, LottoGameResultRepository result, Optional<Currency> currency) {
        Map<LottoPrize, Integer> lottoResult = result.getAllResult();
        long prizeSum = 0;
        for (Map.Entry<LottoPrize, Integer> entry : lottoResult.entrySet()) {
            prizeSum += entry.getKey().winningPrize() * entry.getValue();
        }
        return currency.get().calculate(prizeSum, money);
    }
}
