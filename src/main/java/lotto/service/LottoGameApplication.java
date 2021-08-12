package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.strategy.GenerateLottoNumber;

public class LottoGameApplication {

  private static final int EACH_LOTTO_COST = 1000;

  public static int getBuyCount(LottoMoney lottoMoney){
    return lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE, EACH_LOTTO_COST);
  }

  public static Lotteries createLottos(int count){
    List<Lotto> lottos = IntStream.range(0, count)
        .mapToObj(number -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .collect(Collectors.toList());

    return new Lotteries(lottos);
  }
}