package lotto.domain;

import lotto.constant.Constant;

public class Lottery {

  private final HitNumbers hitNumbers;
  private final Result result = new Result();

  public Lottery(HitNumbers hitNumbers) {
    this.hitNumbers = hitNumbers;
  }

  public int countHit(LottoNumbers lottoNumbers) {
    return (int) lottoNumbers.numbers()
        .stream()
        .filter(hitNumbers::contains).count();
  }

  public void draw(Lottos lottos) {
    for (LottoNumbers numbers : lottos.getLottos()) {
      int hit = countHit(numbers);
      result.update(getHit(numbers, hit));
    }
  }

  private Hit getHit(LottoNumbers numbers, int hit) {
    if (hit == Constant.HIT_OF_BONUS) {
      return Hit.getBonusHit(hitNumbers.containsBonus(numbers));
    }
    return Hit.getHit(hit);
  }

  public Result getResult() {
    return result;
  }
}
