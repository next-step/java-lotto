package study.lottogame.factory;

import java.util.Set;
import study.lottogame.domain.Lottery;
import study.lottogame.util.LottoNumbersGenerator;

public class LotteryFactory {

  private LotteryFactory() {
  }

  public static Lottery create() {
    return new Lottery(Set.copyOf(LottoNumbersGenerator.generate()));
  }

  public static Lottery create(String[] numbers) {
    return new Lottery(Set.copyOf(LottoNumbersGenerator.generate(numbers)));
  }
}
