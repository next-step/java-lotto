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
        return getLottoPrizes(lottoTickets, lottoResult);
    }

    private LottoCheckResponse getLottoPrizes(List<LottoTicket> lottoTickets, LottoResult lottoResult) {
        List<LottoPrize> lottoPrizes = lottoTickets.stream()
            .map(lottoResult::checkLottoTicket)
            .collect(Collectors.toList());

        int earnMoney = 0;
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        Map<LottoPrize, Integer> lottoPrizeCounts = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney += lottoPrize.getMoney();
            lottoPrizeCounts.put(lottoPrize, lottoPrizeCounts.getOrDefault(lottoPrize, 0) + 1);
        }

        double earningRate = (double) earnMoney / (double) totalMoney;
        // 수익률 계산

        return new LottoCheckResponse(earningRate, lottoPrizeCounts);
    }
}
