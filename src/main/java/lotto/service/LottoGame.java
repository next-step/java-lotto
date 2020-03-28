package lotto.service;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;
import lotto.domain.stragegy.LottoGenerator;
import lotto.view.StatisticDataDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private Money money;
    private int playGameCount;
    private LottoTickets lottoTickets;

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
        this.lottoTickets = new LottoTickets(Collections.unmodifiableList(lottos));
    }

//    public double getAllEarningPrize() {
//        this.lottoTickets.getAllEarningPrize();
//    }

//    public StatisticDataDto getStatisticGame() {
//        StatisticDataDto dataDto = new StatisticDataDto();
//        dataDto.setMatchCount3(getMatchCount3LottoCount());
//        dataDto.setMatchCount4(getMatchCount4LottoCount());
//        dataDto.setMatchCount5(getMatchCount5LottoCount());
//        dataDto.setMatchCount6(getMatchCount6LottoCount());
//        dataDto.setEarningRate(getEarningRate() / this.money.getMoney());
//        return dataDto;
//    }
}
