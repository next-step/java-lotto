package lotto.service;

import lotto.domain.Money;
import lotto.domain.item.LottoTicket;
import lotto.domain.stragegy.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private Money money;
    private int playGameCount;
    private List<LottoTicket> lottos;

    public LottoGame(Money money) {
        this.money = money;
        this.playGameCount = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
    }

    private LottoTicket buyOneLottoTicket(List<Integer> numbers) {
        playGameCount--;
        return new LottoTicket(numbers);
    }

    public void buyAllLottoTicket() {
        List<LottoTicket> lottos = new ArrayList<>();
        while (playGameCount > 0) {
            List<Integer> numbers = LottoGenerator.lottoNumberGenerator();
            lottos.add(buyOneLottoTicket(numbers));
        }
        this.lottos = lottos;
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }

//    @Override
//    public String toString() {
//        return lottos.toString() + "\n";
//    }
}
