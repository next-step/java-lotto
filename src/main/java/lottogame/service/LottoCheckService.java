package lottogame.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoResult;
import lottogame.domain.LottoTicket;
import lottogame.service.response.LottoCheckResponse;

public class LottoCheckService {

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        LottoResult lottoResult = new LottoResult(selectedLottoNumbers, bonusLottoNumbers);

        List<LottoPrize> lottoPrizes = lottoTicketsToLottoPrizes(lottoTickets, lottoResult);
        Map<LottoPrize, Integer> lottoPrizeCounts = getLottoPrizeCounts(lottoPrizes);

        return new LottoCheckResponse(calculateEarningRate(lottoPrizes), lottoPrizeCounts);
    }

    private List<LottoPrize> lottoTicketsToLottoPrizes(List<LottoTicket> lottoTickets, LottoResult lottoResult) {
        return lottoTickets.stream()
            .map(lottoResult::checkLottoTicket)
            .collect(Collectors.toList());
    }

    private double calculateEarningRate(List<LottoPrize> lottoPrizes) {
        int earnMoney = 0;
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney += lottoPrize.getMoney();
        }
        return (double) earnMoney / (double) totalMoney;
    }

    private Map<LottoPrize, Integer> getLottoPrizeCounts(List<LottoPrize> lottoPrizes) {
        Map<LottoPrize, Integer> lottoPrizeCounts = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : lottoPrizes) {
            if (lottoPrize == LottoPrize.NONE) {
                continue;
            }
            lottoPrizeCounts.put(lottoPrize, lottoPrizeCounts.getOrDefault(lottoPrize, 0) + 1);
        }
        return lottoPrizeCounts;
    }
}
