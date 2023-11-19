package service;

import domain.Lotto;
import repository.LottoGameResultRepository;
import domain.LottoPrize;
import repository.UserLottoRepository;

import java.util.List;
import java.util.Map;

public class LottoGameService {

    private final UserLottoRepository userLottoRepository;

    public LottoGameService(UserLottoRepository userLottoRepository) {
        this.userLottoRepository = userLottoRepository;
    }

    public Map<Integer, Integer> matchUserLotto(Lotto winningLotto) {
        LottoGameResultRepository lottoMatchResult = new LottoGameResultRepository();
        List<Lotto> lottoTickets = userLottoRepository.getUserLottoTickets();

        int matchCount = 0;
        for (Lotto lottoTicket : lottoTickets) {
            matchCount = lottoTicket.calculateMatchCount(winningLotto);
            lottoMatchResult.saveResult(LottoPrize.fromMatchCount(matchCount).getMatchCount());
        }
        return lottoMatchResult.getAllResult();
    }

    public float calculateReturnRate(long money, Map<Integer, Integer> lottoPrizeIntegerMap) {
        long prizeSum = 0;
        for (Map.Entry<Integer, Integer> entry : lottoPrizeIntegerMap.entrySet()) {
            prizeSum += LottoPrize.fromMatchCount(entry.getKey()).winningPrize() * entry.getValue();
        }
        return (float) prizeSum / money;
    }
}
