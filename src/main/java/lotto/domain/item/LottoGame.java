package lotto.domain.item;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.domain.strategy.LottoNumberAutoGenerator;
import lotto.view.LottoDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final double LOTTO_PRICE = 1000;

    private int playGameCount;
    private LottoTickets lottoTickets;

    public LottoGame() {
    }

    public LottoGame(Money money) {
        this.playGameCount = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
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

    public LottoDto findWinGame(WinLottoTicket winTicket) {
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
