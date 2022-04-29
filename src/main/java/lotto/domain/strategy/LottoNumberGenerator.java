package lotto.domain.strategy;

import java.util.HashSet;
import java.util.Random;
import lotto.domain.LottoNumber;

public class LottoNumberGenerator implements NumberGenerator {

  private final Random random;
  private final HashSet<Integer> generatedSet;

  public LottoNumberGenerator() {
    this.random = new Random();
    this.generatedSet = new HashSet<>();
  }

  @Override
  public int generate() {
    int lottoNum = makeNumber();
    while (generatedSet.contains(lottoNum)) {
      lottoNum = makeNumber();
    }
    generatedSet.add(lottoNum);
    return lottoNum;
  }

  private int makeNumber() {
    return random.nextInt(LottoNumber.MAX - LottoNumber.MIN) + LottoNumber.MIN;
  }
}
