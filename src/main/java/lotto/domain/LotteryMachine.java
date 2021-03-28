package lotto.domain;

public class LotteryMachine {

  private final HitNumbers hitNumbers;
  private final Result result = new Result();

  public LotteryMachine(HitNumbers hitNumbers) {
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
