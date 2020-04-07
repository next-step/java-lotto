package lotto.service;

import enums.Rank;
import lotto.domain.Money;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinLottoTicket;
import lotto.exception.ValidLottoException;
import lotto.view.MatchedLottoDto;
import lotto.view.StatisticsLottoDto;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final String LOTTO_SPLIT_DELIMITER = ",";
    private static final String IMPOSSIBLE_QUANTITY = "구매 불가능한 수량";

    public Money createMoney(final String inputMoney) {
        return new Money(StringUtil.parseStringToInt(inputMoney));
    }

    public int validateAvailableQuantity(final String inputBuyCount, final Money money) {
        int count = StringUtil.parseStringToInt(inputBuyCount);
        int availableQuantity = money.getHowManyBuyItem(new Money(LottoTicket.PRICE));

        if (count > availableQuantity) {
            throw new ValidLottoException(IMPOSSIBLE_QUANTITY);
        }

        return count;
    }

    public MatchedLottoDto playMatchedLotto(final int gameCount) {
        LottoTickets lottoTickets = LottoTickets.from(gameCount);

        MatchedLottoDto dto = new MatchedLottoDto();
        dto.setTickets(lottoTickets);
        return dto;
    }

    public MatchedLottoDto playManuallyLotto(final List<String> buyPassivityNumber) {
        List<LottoNumbers> numbers = new ArrayList<>();

        for (String str : buyPassivityNumber) {
            List<Integer> num =
                    StringUtil.splitStringUseDelimiter(str, LOTTO_SPLIT_DELIMITER)
                            .stream()
                            .map(StringUtil::parseStringToInt)
                            .collect(Collectors.toList());
            numbers.add(LottoNumbers.of(num));
        }

        LottoTickets tickets = LottoTickets.from(numbers);

        MatchedLottoDto dto = new MatchedLottoDto();
        dto.setTickets(tickets);
        return dto;
    }

    public int getAvailableBuyCount(final Money money) {
        return money.getHowManyBuyItem(new Money(LottoTicket.PRICE));
    }

    public StatisticsLottoDto findWinGame(final LottoTickets tickets, final WinLottoTicket winTicket) {
        StatisticsLottoDto dto = new StatisticsLottoDto();
        dto.setFirstGameCount(tickets.findWinLottoCountFromRank(Rank.FIRST, winTicket));
        dto.setSecondGameCount(tickets.findWinLottoCountFromRank(Rank.SECOND, winTicket));
        dto.setThirdGameCount(tickets.findWinLottoCountFromRank(Rank.THIRD, winTicket));
        dto.setFourthGameCount(tickets.findWinLottoCountFromRank(Rank.FOURTH, winTicket));
        dto.setFifthGameCount(tickets.findWinLottoCountFromRank(Rank.FIFTH, winTicket));
        return dto;
    }

    public StatisticsLottoDto getEarningRate(final LottoTickets tickets, final WinLottoTicket winTicket) {
        StatisticsLottoDto dto = new StatisticsLottoDto();
        Money prize = getAllEarningPrize(tickets, winTicket);
        int howManyBuyItem = tickets.size();
        Money buyAmount = new Money(LottoTicket.PRICE).getTotalPurchaseAmount(howManyBuyItem);

        double rate = prize.getEarningRate(buyAmount);

        dto.setEarningRate(rate);
        return dto;
    }

    private Money getAllEarningPrize(final LottoTickets tickets, final WinLottoTicket winTicket) {
        return tickets.getAllEarningPrize(winTicket);
    }
}
