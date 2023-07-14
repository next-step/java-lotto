package lottogame.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoResult;
import lottogame.domain.LottoTicket;
import lottogame.service.response.LottoCheckResponse;

public class LottoCheckService {

    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT_AMOUNT = 1;

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        LottoResult lottoResult = new LottoResult(selectedLottoNumbers, bonusLottoNumbers);
        List<LottoPrize> lottoPrizes = lottoResult.toLottoPrizes(lottoTickets);

        double earningRate = calculateEarningRate(lottoPrizes);
        return new LottoCheckResponse(earningRate, getLottoPrizeCountsExceptNone(lottoPrizes));
    }

    private double calculateEarningRate(List<LottoPrize> lottoPrizes) {
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        int earnMoney = lottoPrizes.stream().mapToInt(LottoPrize::getMoney).sum();

        return (double) earnMoney / (double) totalMoney;
    }

    private Map<LottoPrize, Integer> getLottoPrizeCountsExceptNone(List<LottoPrize> lottoPrizes) {
        Map<LottoPrize, Integer> lottoPrizeCounts = getLottoPrizeCounts(lottoPrizes);
        lottoPrizeCounts.remove(LottoPrize.NONE);
        return lottoPrizeCounts;
    }

    private Map<LottoPrize, Integer> getLottoPrizeCounts(List<LottoPrize> lottoPrizes) {
        Map<LottoPrize, Integer> lottoPrizeCounts = new EnumMap<>(LottoPrize.class);
        lottoPrizes.forEach(lottoPrize -> lottoPrizeCounts.put(lottoPrize,
            lottoPrizeCounts.getOrDefault(lottoPrize, DEFAULT_COUNT) + INCREMENT_AMOUNT));
        return lottoPrizeCounts;
    }
}
