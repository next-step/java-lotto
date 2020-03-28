package lotto.service;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.domain.item.LottoTicket;
import lotto.domain.statisitc.MatchLottoStatistic;
import lotto.domain.stragegy.LottoGenerator;
import lotto.view.StatisticDataDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private Money money;
    private int playGameCount;
    private List<LottoTicket> lottos;
    private MatchLottoStatistic statistic;

    public LottoGame(Money money) {
        this.money = money;
        this.playGameCount = money.getHowManyBuyItem(new Money(LOTTO_PRICE));
        this.statistic = new MatchLottoStatistic();
    }

    public LottoGame(List<LottoTicket> lottos) {
        List<LottoTicket> lotto = new ArrayList<>();
        lotto.addAll(lottos);
        this.lottos = Collections.unmodifiableList(lotto);
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

    public void statisticAllGame(List<Integer> luckyNumber) {
        statistic.collectMatchLotto(lottos, luckyNumber);
    }

    private int getMatchCount3LottoCount() {
        return statistic.findMatchCount3Lottos();
    }

    private int getMatchCount4LottoCount() {
        return statistic.findMatchCount4Lottos();
    }

    private int getMatchCount5LottoCount() {
        return statistic.findMatchCount5Lottos();
    }

    private int getMatchCount6LottoCount() {
        return statistic.findMatchCount6Lottos();
    }

    private double getEarningRate() {
        Money lottoPrice = new Money(LOTTO_PRICE);
        Money earning = new Money();
        money = money.plus(LottoPrize.MATCH3.calculate(getMatchCount3LottoCount()))
                .plus(LottoPrize.MATCH4.calculate(getMatchCount4LottoCount()))
                .plus(LottoPrize.MATCH5.calculate(getMatchCount5LottoCount()))
                .plus(LottoPrize.MATCH6.calculate(getMatchCount6LottoCount()));
        return (earning.getMoney() / (this.money.getHowManyBuyItem(lottoPrice) * lottoPrice.getMoney()) * 100);
    }

    public StatisticDataDto getStatisticGame() {
        StatisticDataDto dataDto = new StatisticDataDto();
        dataDto.setMatchCount3(getMatchCount3LottoCount());
        dataDto.setMatchCount4(getMatchCount4LottoCount());
        dataDto.setMatchCount5(getMatchCount5LottoCount());
        dataDto.setMatchCount6(getMatchCount6LottoCount());
        dataDto.setEarningRate(getEarningRate() / this.money.getMoney());
        return dataDto;
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }
}
