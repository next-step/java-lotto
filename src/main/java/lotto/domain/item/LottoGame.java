package lotto.domain.item;

import enums.Rank;
import lotto.domain.Money;
import lotto.domain.strategy.LottoNumberAutoGenerator;
import lotto.view.LottoDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private int playGameCount;
    private LottoTickets lottoTickets;

    public LottoGame() {
    }

    public LottoGame(Money money) {
        this.playGameCount = money.getHowManyBuyItem(new Money(LottoTicket.PRICE));
    }

    public LottoGame(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets createAutoLottoTicket(int count) {
        List<LottoTicket> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = LottoNumbers.createLottoNumbersUseInteger(LottoNumberAutoGenerator.generateLottoNumber());
            lottos.add(new LottoTicket(numbers));
        }

        return new LottoTickets(lottos);
    }

    public LottoTickets createPassivityLottoTicket(List<LottoNumbers> numbers) {
        return LottoTickets.createLottoToPassivity(numbers);
    }

    public int getAvailableBuyCount(Money money) {
        return money.getHowManyBuyItem(new Money(LottoTicket.PRICE));
    }

    public LottoDto findWinGame(LottoTickets tickets, WinLottoTicket winTicket) {
        LottoDto dto = new LottoDto();
        dto.setFirstGameCount(tickets.findWinLottoCountFromRank(Rank.FIFTH, winTicket));
        dto.setSecondGameCount(tickets.findWinLottoCountFromRank(Rank.SECOND, winTicket));
        dto.setThirdGameCount(tickets.findWinLottoCountFromRank(Rank.THIRD, winTicket));
        dto.setFourthGameCount(tickets.findWinLottoCountFromRank(Rank.FOURTH, winTicket));
        dto.setFifthGameCount(tickets.findWinLottoCountFromRank(Rank.FIFTH, winTicket));
        return dto;
    }

    private Money getAllEarningPrize(LottoTickets tickets, WinLottoTicket winTicket) {
        return tickets.getAllEarningPrize(winTicket);
    }

    public LottoDto getEarningRate(LottoTickets tickets, WinLottoTicket winTicket) {
        LottoDto dto = new LottoDto();
        Money prize = getAllEarningPrize(tickets, winTicket);
        int howManyBuyItem = tickets.size();
        Money buyAmount = Money.buyItemAmount(LottoTicket.PRICE, howManyBuyItem);

        double rate = Math.floor(prize.divide(buyAmount).getMoney() * 100) / 100;

        dto.setEarningRate(rate);
        return dto;
    }
}
