package lotto.strategy;

import lotto.type.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DefaultLottoCreateStrategy implements LottoCreateStrategy {
  private final Random random;

  public DefaultLottoCreateStrategy() {
    this.random = new Random();
  }

  @Override
  public int pick(int min, int max) {
    return random.nextInt(max) + 1;
  }

  @Override
  public List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
    Collections.shuffle(lottoNumbers);
    return lottoNumbers;
  }
}
