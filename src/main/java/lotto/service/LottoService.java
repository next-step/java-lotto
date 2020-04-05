package lotto.service;

import enums.Rank;
import lotto.domain.Money;
import lotto.domain.lotto.*;
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

    public Money createMoney(String inputMoney) {
        return new Money(StringUtil.parseStringToInt(inputMoney));
    }

    public int validateAvailableQuantity(String inputBuyCount, Money money) {
        int count = StringUtil.parseStringToInt(inputBuyCount);
        int availableQuantity = money.getHowManyBuyItem(new Money(LottoTicket.PRICE));

        if (count > availableQuantity) {
            throw new ValidLottoException(IMPOSSIBLE_QUANTITY);
        }

        return count;
    }

    public MatchedLottoDto autoPlay(int gameCount) {
        LottoGame lottoGame = new LottoGame();
        LottoTickets tickets = lottoGame.createAutoLottoTicket(gameCount);

        MatchedLottoDto dto = new MatchedLottoDto();
        dto.setTickets(tickets);
        return dto;
    }

    public MatchedLottoDto passivityPlay(List<String> buyPassivityNumber) {
        LottoGame lottoGame = new LottoGame();
        List<LottoNumbers> numbers = new ArrayList<>();

        for (String str : buyPassivityNumber) {
            List<Integer> num =
                    StringUtil.splitStringUseDelimiter(str, LOTTO_SPLIT_DELIMITER)
                            .stream()
                            .map(StringUtil::parseStringToInt)
                            .collect(Collectors.toList());
            numbers.add(LottoNumbers.of(num));
        }

        LottoTickets tickets = lottoGame.createPassivityLottoTicket(numbers);

        MatchedLottoDto dto = new MatchedLottoDto();
        dto.setTickets(tickets);
        return dto;
    }

    public int getAvailableBuyCount(Money money) {
        LottoGame lottoGame = new LottoGame();
        return lottoGame.getAvailableBuyCount(money);
    }

    public StatisticsLottoDto findWinGame(LottoTickets tickets, WinLottoTicket winTicket) {
        StatisticsLottoDto dto = new StatisticsLottoDto();
        dto.setFirstGameCount(tickets.findWinLottoCountFromRank(Rank.FIRST, winTicket));
        dto.setSecondGameCount(tickets.findWinLottoCountFromRank(Rank.SECOND, winTicket));
        dto.setThirdGameCount(tickets.findWinLottoCountFromRank(Rank.THIRD, winTicket));
        dto.setFourthGameCount(tickets.findWinLottoCountFromRank(Rank.FOURTH, winTicket));
        dto.setFifthGameCount(tickets.findWinLottoCountFromRank(Rank.FIFTH, winTicket));
        return dto;
    }

    public StatisticsLottoDto getEarningRate(LottoTickets tickets, WinLottoTicket winTicket) {
        StatisticsLottoDto dto = new StatisticsLottoDto();
        Money prize = getAllEarningPrize(tickets, winTicket);
        int howManyBuyItem = tickets.size();
        Money buyAmount = Money.getTotalPurchaseAmount(new Money(LottoTicket.PRICE), howManyBuyItem);

        double rate = Math.floor(prize.divide(buyAmount).getMoney() * 100) / 100;

        dto.setEarningRate(rate);
        return dto;
    }

    private Money getAllEarningPrize(LottoTickets tickets, WinLottoTicket winTicket) {
        return tickets.getAllEarningPrize(winTicket);
    }
}
