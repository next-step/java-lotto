package study.lottogame.factory;

import java.util.List;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.util.LottoNumbersGenerator;

public class LotteryFactory {

  private LotteryFactory() {
  }

  public static Lottery create() {
    return new Lottery(LottoNumbersGenerator.generate());
  }

  public static Lottery create(List<LottoNumber> lottoNumbers) {
    return new Lottery(lottoNumbers);
  }
}
