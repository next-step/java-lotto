package lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.dto.LottoTicketDto;
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

    public LottoCheckedResponse checkResult(List<LottoTicketDto> lottoTicketDtos) {
        List<LottoTicket> lottoTickets = toLottoTickets(lottoTicketDtos);
        List<LottoPrize> lottoPrizes = toLottoPrizes(lottoTickets);

        double earningRate = calculateEarningRate(lottoPrizes);

        return new LottoCheckedResponse(earningRate, getLottoTicketCheckResponsesWithOutNone(lottoPrizes));
    }

    private List<LottoTicket> toLottoTickets(List<LottoTicketDto> lottoTicketDtos) {
        return lottoTicketDtos.stream()
            .map(lottoTicketDto -> new LottoTicket(lottoTicketDto.getNumbers()))
            .collect(Collectors.toList());
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

    private double calculateEarningRate(List<LottoPrize> lottoPrizes) {
        int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
        int earnMoney = ZERO_MONEY;
        for (LottoPrize lottoPrize : lottoPrizes) {
            earnMoney += lottoPrize.getMoney();
        }
        return (double) earnMoney / (double) totalMoney;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCheckManager)) {
            return false;
        }
        LottoCheckManager that = (LottoCheckManager) o;
        return Objects.equals(lottoResultNumbers, that.lottoResultNumbers) && Objects.equals(lottoBonus,
            that.lottoBonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultNumbers, lottoBonus);
    }

    @Override
    public String toString() {
        return "LottoCheckManager{" +
            "lottoResultNumbers=" + lottoResultNumbers +
            ", lottoBonus=" + lottoBonus +
            '}';
    }
}
