package lotto.domain;

public class Lottery {

  private final HitNumbers hitNumbers;
  private final Result result = new Result();

  public Lottery(HitNumbers hitNumbers) {
    this.hitNumbers = hitNumbers;
  }

  public void draw(Lottos lottos) {
    for (LottoNumbers numbers : lottos.getLottos()) {
      result.update(Hit.getHit(hitNumbers, numbers));
    }
  }

  public Result getResult() {
    return result;
  }
}
