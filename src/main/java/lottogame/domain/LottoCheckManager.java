package lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketCheckedResponse;

public class LottoCheckManager {

    private static final int ZERO_MONEY = 0;
    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT_AMOUNT = 1;
    private static final LottoTicketCheckedResponse EXCEPTED_LOTTO_TICKET_RESPONSE = new LottoTicketCheckedResponse(
        LottoPrize.NONE.getMatchedCount(), LottoPrize.NONE.getMoney());

    private final LottoTicket lottoResultNumbers;
    private final LottoNumber lottoBonus;

    public LottoCheckManager(Set<Integer> lottoResultNumbers, int bonusNumber) {
        assertBonusNumber(bonusNumber, lottoResultNumbers);
        this.lottoResultNumbers = new LottoTicket(lottoResultNumbers);
        this.lottoBonus = LottoNumber.valueOf(bonusNumber);
    }

    private void assertBonusNumber(Integer bonusNumber, Set<Integer> lottoResultNumbers) {
        if (lottoResultNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                String.format("bonusNumber \"%d\"는 lottoResultNumbers\"%s\"와 중복될 수 없습니다.", bonusNumber,
                    lottoResultNumbers));
        }
    }

    public LottoCheckedResponse checkResult(List<LottoTicket> lottoTicketRespons) {
        List<LottoPrize> lottoPrizes = toLottoPrizes(lottoTicketRespons);

        double earningRate = calculateEarningRate(lottoPrizes);
        return new LottoCheckedResponse(earningRate, getLottoTicketCheckResponsesWithOutNone(lottoPrizes));
    }

    private double calculateEarningRate(List<LottoPrize> lottoPrizes) {
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        int earnMoney = ZERO_MONEY;
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney += lottoPrize.getMoney();
        }
        return (double) earnMoney / (double) totalMoney;
    }

    private List<LottoPrize> toLottoPrizes(List<LottoTicket> lottoTicketRespons) {
        return lottoTicketRespons.stream()
            .map(this::toLottoPrize)
            .collect(Collectors.toList());
    }

    private LottoPrize toLottoPrize(LottoTicket lottoTicket) {
        return LottoPrize.of(lottoResultNumbers.getMatchedCount(lottoTicket),
            lottoTicket.contains(lottoBonus));
    }

    private Map<LottoTicketCheckedResponse, Integer> getLottoTicketCheckResponsesWithOutNone(
        List<LottoPrize> lottoPrizes) {
        Map<LottoTicketCheckedResponse, Integer> lottoTicketCheckResponses = getLottoTicketCheckResponses(lottoPrizes);
        lottoTicketCheckResponses.remove(EXCEPTED_LOTTO_TICKET_RESPONSE);
        return lottoTicketCheckResponses;
    }

    private Map<LottoTicketCheckedResponse, Integer> getLottoTicketCheckResponses(List<LottoPrize> lottoPrizes) {
        Map<LottoTicketCheckedResponse, Integer> lottoPrizeCounts = new HashMap<>();
        lottoPrizes.forEach(lottoPrize -> lottoPrizeCounts.put(
            new LottoTicketCheckedResponse(lottoPrize.getMatchedCount(), lottoPrize.getMoney()),
            lottoPrizeCounts.getOrDefault(
                new LottoTicketCheckedResponse(lottoPrize.getMatchedCount(), lottoPrize.getMoney()), DEFAULT_COUNT)
                + INCREMENT_AMOUNT));
        return lottoPrizeCounts;
    }
}
