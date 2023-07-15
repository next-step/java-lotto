package lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketCheckedResponse;

public class LottoCheckManager {

    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT_AMOUNT = 1;
    private static final LottoTicketCheckedResponse EXCEPTED_LOTTO_TICKET_RESPONSE = new LottoTicketCheckedResponse(
        LottoPrize.NONE.getMatchedCount(), LottoPrize.NONE.getMoney());

    private final LottoResult lottoResult;

    public LottoCheckManager(Set<Integer> lottoResultNumbers, int bonusNumber) {
        this.lottoResult = new LottoResult(new LottoTicket(lottoResultNumbers), LottoNumber.valueOf(bonusNumber));
    }

    public LottoCheckedResponse checkResult(List<LottoTicketDto> lottoTicketDtos) {
        List<LottoTicket> lottoTickets = toLottoTickets(lottoTicketDtos);

        double earningRate = lottoResult.calculateEarningRate(lottoTickets);

        return new LottoCheckedResponse(earningRate,
            toLottoTicketCheckResponsesWithOutNone(lottoResult.toLottoPrizes(lottoTickets)));
    }

    private List<LottoTicket> toLottoTickets(List<LottoTicketDto> lottoTicketDtos) {
        return lottoTicketDtos.stream()
            .map(lottoTicketDto -> new LottoTicket(lottoTicketDto.getNumbers()))
            .collect(Collectors.toList());
    }

    private Map<LottoTicketCheckedResponse, Integer> toLottoTicketCheckResponsesWithOutNone(
        List<LottoPrize> lottoPrizes) {
        Map<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses = toLottoTicketCheckResponses(lottoPrizes);
        lottoTicketCheckResponses.remove(EXCEPTED_LOTTO_TICKET_RESPONSE);
        return lottoTicketCheckResponses;
    }

    private Map<LottoTicketCheckedResponse, Integer> toLottoTicketCheckResponses(List<LottoPrize> lottoPrizes) {
        Map<LottoTicketCheckedResponse, Integer> lottoPrizeCounts = new HashMap<>();
        lottoPrizes.forEach(lottoPrize -> lottoPrizeCounts.put(
            new LottoTicketCheckedResponse(lottoPrize.getMatchedCount(), lottoPrize.getMoney()),
            lottoPrizeCounts.getOrDefault(
                new LottoTicketCheckedResponse(lottoPrize.getMatchedCount(), lottoPrize.getMoney()), DEFAULT_COUNT)
                + INCREMENT_AMOUNT));
        return lottoPrizeCounts;
    }

}
