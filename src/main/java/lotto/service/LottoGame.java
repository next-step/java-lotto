package lotto.service;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.domain.item.Item;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;
import lotto.domain.item.WinLottoTicket;
import lotto.domain.stragegy.LottoNumberGenerator;
import lotto.view.LottoDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final double LOTTO_PRICE = 1000;

    private int playGameCount;
    private LottoTickets lottoTickets;

    public LottoGame(Money money) {
        this.playGameCount = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
    }

    public LottoGame(Money money, LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private LottoTicket buyOneLottoTicket(List<Integer> numbers) {
        playGameCount--;
        return new LottoTicket(numbers);
    }

    private void buyAllLottoTicket() {
        List<LottoTicket> lottos = new ArrayList<>();
        while (playGameCount > 0) {
            List<Integer> numbers = LottoNumberGenerator.generateLottoNumber();
            lottos.add(buyOneLottoTicket(numbers));
        }
        this.lottoTickets = new LottoTickets(Collections.unmodifiableList(lottos));
    }

    public LottoDto play() {
        buyAllLottoTicket();
        LottoDto dto = new LottoDto();

        dto.setTickets(this.lottoTickets.getTickets());

        return dto;
    }

    public LottoDto findWinGame(Item winTicket) {
        LottoDto dto = new LottoDto();
        dto.setFirstGameCount(this.lottoTickets.findWinLottoCountFromRank(LottoPrize.FIFTH, winTicket));
        dto.setSecondGameCount(this.lottoTickets.findWinLottoCountFromRank(LottoPrize.SECOND, winTicket));
        dto.setThirdGameCount(this.lottoTickets.findWinLottoCountFromRank(LottoPrize.THIRD, winTicket));
        dto.setFourthGameCount(this.lottoTickets.findWinLottoCountFromRank(LottoPrize.FOURTH, winTicket));
        dto.setFifthGameCount(this.lottoTickets.findWinLottoCountFromRank(LottoPrize.FIFTH, winTicket));
        return dto;
    }

    private Money getAllEarningPrize(WinLottoTicket winTicket) {
        return this.lottoTickets.getAllEarningPrize(winTicket);
    }

    public LottoDto getEarningRate(WinLottoTicket winTicket) {
        LottoDto dto = new LottoDto();
        Money prize = getAllEarningPrize(winTicket);
        int howManyBuyItem = this.lottoTickets.size();
        Money buyAmount = Money.buyItemAmount(LOTTO_PRICE, howManyBuyItem);

        double rate = Math.floor(prize.divide(buyAmount).getMoney() * 100) / 100;

        dto.setEarningRate(rate);
        return dto;
    }
}
