package lotto.domain;

import java.util.List;

public class Lottery {

  private final HitNumber hitNumber;
  public Result result = new Result();

  public Lottery(HitNumber hitNumber) {
    this.hitNumber = hitNumber;
  }

  public int countHit(LottoNumbers lottoNumbers) {
    return (int) lottoNumbers.numbers()
        .stream()
        .filter(hitNumber::contains).count();
  }

  public void draw(List<LottoNumbers> lottos) {
    for (LottoNumbers numbers : lottos) {
      int hit = countHit(numbers);
      result.update(hit);
    }
  }
}
