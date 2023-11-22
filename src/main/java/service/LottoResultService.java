package service;

import domain.Currency;
import domain.Lotto;
import domain.WinningLotto;
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

    public LottoGameResultRepository matchUserLotto(WinningLotto winningLotto) {
        LottoGameResultRepository lottoMatchResult = new LottoGameResultRepository();
        List<Lotto> lottoTickets = userLottoRepository.getUserLottoTickets();

        int matchCount = 0;
        boolean matchBonus = false;
        for (Lotto lottoTicket : lottoTickets) {
            matchCount = lottoTicket.calculateMatchCount(winningLotto);
            matchBonus = lottoTicket.isMatchBonusNumber(winningLotto);
            lottoMatchResult.saveResult(getPrize(matchCount, matchBonus));
        }
        return lottoMatchResult;
    }

    private static LottoPrize getPrize(int matchCount, boolean matchBonus) {
        return LottoPrize.fromMatchCount(matchCount, matchBonus);
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
