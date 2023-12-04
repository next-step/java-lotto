package lotto.domain;

import lotto.generator.LottoNumbersMakeStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class LottoGame {

    public final static Money ONE_TRY_MONEY = new Money(1_000);

    private final List<Lotto> lottos;

    private final Money tryMoney;

    private LottoGame(List<Lotto> lottos, Money money) {
        this.lottos = lottos;
        this.tryMoney = money;
    }

    public static LottoGame create(Money tryMoney, LottoNumbersMakeStrategy makeNumberStrategy) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < getTryCount(tryMoney) ; i++) {
            lottoList.add(Lotto.create(makeNumberStrategy.makeLottoNumber()));
        }
        return new LottoGame(lottoList, tryMoney);
    }

    private static int getTryCount(Money tryMoney) {
        return tryMoney.divide(ONE_TRY_MONEY).intValue();
    }

    public List<Lotto> getLotto() {
        return this.lottos;
    }

    public Prizes game(WinGenerator generator) {
        return new Prizes(getPrizes(generator), tryMoney);
    }

    public List<Prize> getPrizes(WinGenerator generator) {
        return lottos.stream()
                .map(generator::winPrize)
                .collect(Collectors.toList());
    }

    public List<String> createFormattedLotto() {
        return getLotto().stream()
                .map(Lotto::createFormattedLotto)
                .collect(Collectors.toList());
    }

}
