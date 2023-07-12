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
        List<LottoPrize> list = lottoTickets.stream()
            .map(lottoResult::checkLottoTicket)
            .collect(Collectors.toList());

        double earningRate = 0;
        Map<LottoPrize, Integer> lottoPrizes = new EnumMap<>(LottoPrize.class);

        return new LottoCheckResponse(earningRate, lottoPrizes);
    }
}
