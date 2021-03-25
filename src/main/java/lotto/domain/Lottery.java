package lotto.domain;

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
      result.update(Hit.getHit(hitNumbers, numbers, hit));
    }
  }

  public Result getResult() {
    return result;
  }
}
